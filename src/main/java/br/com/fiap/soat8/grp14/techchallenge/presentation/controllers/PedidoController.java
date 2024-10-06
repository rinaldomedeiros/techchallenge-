package br.com.fiap.soat8.grp14.techchallenge.presentation.controllers;

import br.com.fiap.soat8.grp14.techchallenge.app.dto.pedido.PedidoDTO;
import br.com.fiap.soat8.grp14.techchallenge.app.services.PedidoService;
import br.com.fiap.soat8.grp14.techchallenge.app.services.ProdutoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.core.annotation.Order;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/pedidos")
@Order(3)
@Tag(name = "Pedido", description = "API REST para cadastro e controle de pedidos")
@AllArgsConstructor
public class PedidoController {

    private final PedidoService pedidoService;


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

    @Operation(summary = "Este endpoint é responsável por listar os pedidos.")
    @GetMapping
    public ResponseEntity<List<PedidoDTO>> getPedidos() {
        return ResponseEntity.ok(this.pedidoService.listarTodos());
    }


}
