package br.com.fiap.soat8.grp14.techchallenge.application.ports.in;

import java.util.List;

import br.com.fiap.soat8.grp14.techchallenge.app.dto.pedido.PedidoDTO;
import br.com.fiap.soat8.grp14.techchallenge.app.exceptions.EmptyItensException;

public interface PedidoServicePort {
    void processarPedido(Long pedidoId);

    List<PedidoDTO> buscarPedidos();

    PedidoDTO salvarPedido(PedidoDTO pedido) throws EmptyItensException;
}
