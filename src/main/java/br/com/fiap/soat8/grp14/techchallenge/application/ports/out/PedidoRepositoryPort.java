package br.com.fiap.soat8.grp14.techchallenge.application.ports.out;

import java.util.List;
import java.util.Optional;

import br.com.fiap.soat8.grp14.techchallenge.domain.models.Pedido;

public interface PedidoRepositoryPort {

    List<Pedido> buscarTodos();

    Pedido salvarPedido(Pedido pedido);

    Optional<Integer> obterUltimoNumeroPedido();
}
