package br.com.fiap.soat8.grp14.techchallenge.application.ports.out;

import br.com.fiap.soat8.grp14.techchallenge.adapters.dto.PedidoDTO;

public interface PedidoRepositoryPort {
    PedidoDTO buscarPorId(Long id);
    void salvarPedido(PedidoDTO pedido);
}