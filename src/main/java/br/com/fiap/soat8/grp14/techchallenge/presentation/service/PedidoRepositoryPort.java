package br.com.fiap.soat8.grp14.techchallenge.presentation.service;

import java.util.List;
import java.util.Optional;

import br.com.fiap.soat8.grp14.techchallenge.core.entities.Pedido;

public interface PedidoRepositoryPort {

    List<Pedido> buscarTodos();

    Pedido salvarPedido(Pedido pedido);

    Optional<Integer> obterUltimoNumeroPedido();
}
