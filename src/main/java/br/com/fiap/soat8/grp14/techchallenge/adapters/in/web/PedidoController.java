package br.com.fiap.soat8.grp14.techchallenge.adapters.in.web;

import br.com.fiap.soat8.grp14.techchallenge.adapters.dto.PedidoDTO;
import br.com.fiap.soat8.grp14.techchallenge.application.ports.in.PedidoServicePort;

import br.com.fiap.soat8.grp14.techchallenge.domain.exceptions.EmptyItensException;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

import org.springframework.web.bind.annotation.*;

import java.util.List;

import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@RestController
@RequestMapping("/api/pedidos")
@Order(3)
@Tag(name = "Pedido", description = "API REST para cadastro e controle de pedidos")
public class PedidoController {

    private final PedidoServicePort pedidoServicePort;

    public PedidoController(PedidoServicePort pedidoServicePort) {
        this.pedidoServicePort = pedidoServicePort;
    }

    @PostMapping
    @Operation(summary = "Este endpoint é responsável por criar o pedido (Fake checkout).")
    public ResponseEntity<PedidoDTO> salvarPedidos(@RequestBody PedidoDTO pedidoDTO) throws EmptyItensException {
        PedidoDTO pedidoSalvo = pedidoServicePort.salvarPedido(pedidoDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(pedidoSalvo);
    }

    @GetMapping
    @Operation(summary = "Este endpoint é responsável por listar os pedidos.")
    public ResponseEntity<List<PedidoDTO>> findAll() {
        return ResponseEntity.ok().body(pedidoServicePort.buscarPedidos());
    }

}
