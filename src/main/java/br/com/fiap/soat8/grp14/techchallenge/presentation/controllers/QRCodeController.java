package br.com.fiap.soat8.grp14.techchallenge.presentation.controllers;

import java.net.MalformedURLException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDateTime;

import org.springframework.core.annotation.Order;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.fiap.soat8.grp14.techchallenge.app.dto.QRCode.QRCodeDTO;
import br.com.fiap.soat8.grp14.techchallenge.app.dto.pedido.PedidoDTO;
import br.com.fiap.soat8.grp14.techchallenge.app.services.PedidoService;
import br.com.fiap.soat8.grp14.techchallenge.app.services.QRCodeService;
import br.com.fiap.soat8.grp14.techchallenge.presentation.controllers.util.StandardError;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/api/qrcode")
@Tag(name = "QR-Code", description = "API REST para geraçao de QR-Code")
@Order(4)
public class QRCodeController {

	private final QRCodeService qrCodeService;
    private final PedidoService pedidoService;

    public QRCodeController(QRCodeService qrCodeService, PedidoService pedidoService) {
        this.qrCodeService = qrCodeService;
        this.pedidoService = pedidoService;
    }

    @PostMapping("/{idPedido}/")
    @Operation(summary = "Este endpoint é responsável por gerar o QR-Code de pagamento.")
    @ApiResponses(value = {
    	    @ApiResponse(responseCode = "200", description = "QR Code gerado com sucesso", content = @Content(schema = @Schema(implementation = QRCodeDTO.class))),
    	    @ApiResponse(responseCode = "500", description = "Erro ao gerar o QR Code", content = @Content(schema = @Schema(implementation = StandardError.class)))
    })
    public ResponseEntity<?> gerarQrCode(@PathVariable Long idPedido) {
        try {
            PedidoDTO pedido = pedidoService.buscarPedido(idPedido);

            QRCodeDTO qrCodeDTO = qrCodeService.gerarQrCode(
                idPedido.toString(),
                pedido.getItens(),
                pedido.getValorTotal()); 
            
            // Salvar o QR Code como arquivo
            String filePath = "qrcodes/qr_" + idPedido + ".png";
            qrCodeService.salvarQrCodeComoArquivo(qrCodeDTO.getQrData(), filePath);

            return ResponseEntity.ok(qrCodeDTO);

        } catch (Exception e) {
        	StandardError erro = new StandardError(HttpStatus.INTERNAL_SERVER_ERROR, "Erro ao gerar o QR Code.", LocalDateTime.now());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(erro);
        }
    }
    
    
    @GetMapping("/{idPedido}/imagem")
    @Operation(summary = "Este endpoint retorna a imagem do QR Code gerado.")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Imagem do QR Code", content = @Content(mediaType = MediaType.IMAGE_PNG_VALUE)),
        @ApiResponse(responseCode = "404", description = "QR Code não encontrado")
    })
    public ResponseEntity<?> visualizarQrCode(@PathVariable Long idPedido) {
        try {
            Path filePath = Paths.get("qrcodes/qr_" + idPedido + ".png");
            Resource resource = new UrlResource(filePath.toUri());

            if (resource.exists() || resource.isReadable()) {
                HttpHeaders headers = new HttpHeaders();
                headers.setContentType(MediaType.IMAGE_PNG);

                return new ResponseEntity<>(resource, headers, HttpStatus.OK);
            } else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("QR Code não encontrado.");
            }

        } catch (MalformedURLException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Erro ao acessar o arquivo do QR Code.");
        }
    }
    
}