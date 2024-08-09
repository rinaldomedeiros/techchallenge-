package br.com.fiap.soat8.grp14.techchallenge.domain.usecases;

import java.util.List;
import java.util.stream.Collectors;

import br.com.fiap.soat8.grp14.techchallenge.adapters.dto.PedidoDTO;
import br.com.fiap.soat8.grp14.techchallenge.application.ports.in.PedidoServicePort;
import br.com.fiap.soat8.grp14.techchallenge.application.ports.out.PedidoRepositoryPort;
import br.com.fiap.soat8.grp14.techchallenge.domain.models.Pedido;

public class PedidoServiceImpl implements PedidoServicePort {

    private final PedidoRepositoryPort pedidoRepositoryPort;

    public PedidoServiceImpl(PedidoRepositoryPort pedidoRepositoryPort) {
        this.pedidoRepositoryPort = pedidoRepositoryPort;
    }

    @Override
    public void processarPedido(Long pedidoId) {
    //    pedidoServicePort.iniciarCheckout(pedidoId);
    }

    @Override
    public List<PedidoDTO> buscarPedidos() {
        List<Pedido> pedidos = this.pedidoRepositoryPort.buscarTodos();
        return pedidos.stream().map(Pedido::toPedidoDTO).collect(Collectors.toList());
    }

    @Override
    public void salvarPedido(PedidoDTO pedidoDTO) {
        this.pedidoRepositoryPort.salvarPedido(new Pedido(pedidoDTO));
    }
}
