package br.com.fiap.soat8.grp14.techchallenge.presentation.controllers;

import br.com.fiap.soat8.grp14.techchallenge.app.dto.pedido.PedidoAtualizarStatusDTO;
import br.com.fiap.soat8.grp14.techchallenge.app.dto.pedido.PedidoDTO;
import br.com.fiap.soat8.grp14.techchallenge.app.dto.pedido.PedidoInsertDTO;
import br.com.fiap.soat8.grp14.techchallenge.app.services.PedidoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/pedidos")
@Order(3)
@Tag(name = "Pedido", description = "API REST para cadastro e controle de pedidos")
@AllArgsConstructor
public class PedidoController {

    private final PedidoService pedidoService;


    @Operation(summary = "Este endpoint é responsável por listar os pedidos.")
    @GetMapping
    public ResponseEntity<List<PedidoDTO>> getPedidos() {
        return ResponseEntity.ok(this.pedidoService.listarTodos());
    }

    @PostMapping
    @Operation(summary = "Este endpoint é responsável por criar o pedido.")
    public ResponseEntity<PedidoDTO> salvarPedidos(@Validated @RequestBody PedidoInsertDTO pedidoInsertDTO) {
        PedidoDTO pedidoSalvo = pedidoService.salvarPedido(pedidoInsertDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(pedidoSalvo);
    }

    @PutMapping("/status")
    @Operation(summary = "Este endpoint atualiza o status do pedido pelo número.")
    public ResponseEntity<PedidoDTO> atualizaStatusPedido(@Valid @RequestBody PedidoAtualizarStatusDTO pedidoAtualizarStatusDTO) {
        PedidoDTO pedidoAtualizado = pedidoService.atualizarStatus(pedidoAtualizarStatusDTO);
        return ResponseEntity.ok(pedidoAtualizado);
    }

    @GetMapping("/status")
    @Operation(summary = "Este endpoint lista pedidos,de forma ordenda do mais antigo para o mais novo ,por status.")
    public ResponseEntity<List<PedidoDTO>> listaPedidoOrdenado() {
        return ResponseEntity.ok(this.pedidoService.listarPedidosOrdenado());
    }


}
