package br.com.fiap.soat8.grp14.techchallenge.application.ports.out;

import java.util.List;

import br.com.fiap.soat8.grp14.techchallenge.domain.models.Pedido;

public interface PedidoRepositoryPort {

    List<Pedido> buscarTodos();

    void salvarPedido(Pedido pedido);

}
