package br.com.fiap.soat8.grp14.techchallenge.application.services;

import br.com.fiap.soat8.grp14.techchallenge.adapters.dto.PedidoDTO;
import br.com.fiap.soat8.grp14.techchallenge.application.ports.in.CheckoutServicePort;
import br.com.fiap.soat8.grp14.techchallenge.application.ports.out.PedidoRepositoryPort;
import br.com.fiap.soat8.grp14.techchallenge.domain.enums.StatusPedido;
import org.springframework.stereotype.Service;

@Service
public class FakeCheckoutService implements CheckoutServicePort {

    private final PedidoRepositoryPort pedidoRepositoryPort;

    public FakeCheckoutService(PedidoRepositoryPort pedidoRepositoryPort) {
        this.pedidoRepositoryPort = pedidoRepositoryPort;
    }

    @Override
    public void processarCheckout(Long pedidoId) {
        // Obter pedido
        PedidoDTO pedido = pedidoRepositoryPort.buscarPorId(pedidoId);

        // Simular requisição de pagamento fake
        boolean pagamentoConfirmado = simularRequisicaoPagamento(pedido);

        // Atualizar status do pedido
        if (pagamentoConfirmado) {
            pedido.setStatus(StatusPedido.PAID);
        } else {
            pedido.setStatus(StatusPedido.CANCELLED);
        }

        // Salvar atualizações no repositório
        pedidoRepositoryPort.salvarPedido(pedido);
    }

    private boolean simularRequisicaoPagamento(PedidoDTO pedido) {
        // Simular lógica de pagamento (sempre retorna true para sucesso)
        return true;
    }
}
