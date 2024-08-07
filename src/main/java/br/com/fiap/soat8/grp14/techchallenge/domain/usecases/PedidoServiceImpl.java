package br.com.fiap.soat8.grp14.techchallenge.domain.usecases;

import java.util.List;

import br.com.fiap.soat8.grp14.techchallenge.adapters.dto.PedidoDTO;
import br.com.fiap.soat8.grp14.techchallenge.application.ports.in.CheckoutPort;
import br.com.fiap.soat8.grp14.techchallenge.application.ports.in.PedidoServicePort;

public class PedidoServiceImpl implements PedidoServicePort {

    private final CheckoutPort checkoutPort;

    public PedidoServiceImpl(CheckoutPort checkoutPort) {
        this.checkoutPort = checkoutPort;
    }

    @Override
    public void processarPedido(Long pedidoId) {
        checkoutPort.iniciarCheckout(pedidoId);
    }

    @Override
    public List<PedidoDTO> buscarPedidos() {
        //TODO
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void salvarPedido(PedidoDTO pedido) {
        //TODO
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
