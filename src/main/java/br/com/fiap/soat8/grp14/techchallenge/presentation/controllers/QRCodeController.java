package br.com.fiap.soat8.grp14.techchallenge.presentation.controllers;

import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.fiap.soat8.grp14.techchallenge.app.dto.pedido.PedidoDTO;
import br.com.fiap.soat8.grp14.techchallenge.app.services.PedidoService;
import br.com.fiap.soat8.grp14.techchallenge.app.services.QRCodeService;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/api/qrcode")
@Tag(name = "QR-Code", description = "API REST para geraçao de QR-Code")
@Order(2)
public class QRCodeController {

	private final QRCodeService qrCodeService;
    private final PedidoService pedidoService;

    public QRCodeController(QRCodeService qrCodeService, PedidoService pedidoService) {
        this.qrCodeService = qrCodeService;
        this.pedidoService = pedidoService;
    }

    @PostMapping("/{nrPedido}/")
    public ResponseEntity<String> gerarQrCode(@PathVariable Integer nrPedido) {
        try {
            // Buscar o pedido existente
            PedidoDTO pedido = pedidoService.buscarPorNumero(nrPedido);

            
            // Usar os dados do pedido para gerar o QR Code
            String qrCodeUrl = qrCodeService.gerarQrCode(
                pedido.getId().toString(),
                pedido.getItens(),
                pedido.getValorTotal()); 

            return ResponseEntity.ok(qrCodeUrl);

        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Erro ao gerar o QR Code.");
        }
    }
}