package br.com.fiap.soat8.grp14.techchallenge.presentation.controllers;

import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.core.annotation.Order;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/pedidos")
@Order(3)
@Tag(name = "Pedido", description = "API REST para cadastro e controle de pedidos")
public class PedidoController {

//    private final PedidoServicePort pedidoServicePort;
//
//    public PedidoController(PedidoServicePort pedidoServicePort) {
//        this.pedidoServicePort = pedidoServicePort;
//    }
//
//    @PostMapping
//    @Operation(summary = "Este endpoint é responsável por criar o pedido (Fake checkout).")
//    public ResponseEntity<PedidoDTO> salvarPedidos(@RequestBody PedidoDTO pedidoDTO) throws EmptyItensException {
//        PedidoDTO pedidoSalvo = pedidoServicePort.salvarPedido(pedidoDTO);
//        return ResponseEntity.status(HttpStatus.CREATED).body(pedidoSalvo);
//    }
//
//    @GetMapping
//    @Operation(summary = "Este endpoint é responsável por listar os pedidos.")
//    public ResponseEntity<List<PedidoDTO>> findAll() {
//        return ResponseEntity.ok().body(pedidoServicePort.buscarPedidos());
//    }

}
