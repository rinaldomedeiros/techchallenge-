package br.com.fiap.soat8.grp14.techchallenge.adapters.in.web;

import br.com.fiap.soat8.grp14.techchallenge.adapters.dto.PedidoDTO;
import br.com.fiap.soat8.grp14.techchallenge.application.ports.in.PedidoServicePort;

import br.com.fiap.soat8.grp14.techchallenge.domain.exceptions.EmptyItensException;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@RestController
@RequestMapping("/api/pedidos")
public class PedidoController {

    private final PedidoServicePort pedidoServicePort;

    public PedidoController(PedidoServicePort pedidoServicePort) {
        this.pedidoServicePort = pedidoServicePort;
    }

    @PostMapping
    public ResponseEntity<String> salvarPedidos(@RequestBody PedidoDTO pedidoDTO) throws EmptyItensException {
        pedidoServicePort.salvarPedido(pedidoDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body("Pedido criado com sucesso!");
    }

    @GetMapping
    public ResponseEntity<List<PedidoDTO>> findAll() {
        return ResponseEntity.ok().body(pedidoServicePort.buscarPedidos());
    }

}
