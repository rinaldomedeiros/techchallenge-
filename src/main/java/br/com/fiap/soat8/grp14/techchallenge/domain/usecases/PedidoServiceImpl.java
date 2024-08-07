package br.com.fiap.soat8.grp14.techchallenge.domain.usecases;

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
}
