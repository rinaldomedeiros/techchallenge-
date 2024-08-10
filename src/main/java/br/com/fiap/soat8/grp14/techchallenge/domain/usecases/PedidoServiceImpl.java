package br.com.fiap.soat8.grp14.techchallenge.domain.usecases;

import java.util.List;
import java.util.stream.Collectors;

import br.com.fiap.soat8.grp14.techchallenge.adapters.dto.ItemPedidoDTO;
import br.com.fiap.soat8.grp14.techchallenge.adapters.dto.PedidoDTO;
import br.com.fiap.soat8.grp14.techchallenge.application.ports.in.PedidoServicePort;
import br.com.fiap.soat8.grp14.techchallenge.application.ports.out.PedidoRepositoryPort;
import br.com.fiap.soat8.grp14.techchallenge.domain.enums.StatusPedido;
import br.com.fiap.soat8.grp14.techchallenge.domain.exceptions.EmptyItensException;
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
    public void salvarPedido(PedidoDTO pedidoDTO) throws EmptyItensException {
        if (pedidoDTO.getItens() == null || pedidoDTO.getItens().isEmpty())
            throw new EmptyItensException("Erro ao salvar o pedido: deve ser selecionado pelo menos um produto para realizar o pedido.");

        pedidoDTO.setValorTotal(this.calcularTotalPedido(pedidoDTO.getItens()));

        //TODO: criar funcionalidade para numerar o Pedido
        //TODO: validar se o item de pedido está preenchido corretamente: se o produto foi informado e se a quantidade é válida.
        Pedido pedido = new Pedido(pedidoDTO);
        pedido.setStatusPedido(StatusPedido.RECEBIDO);
        this.pedidoRepositoryPort.salvarPedido(pedido);
    }

    private Double calcularTotalPedido(List<ItemPedidoDTO> itens) {
        return itens.stream()
                .mapToDouble(item -> item.getQuantidade() * item.getValorItem())
                .sum();
    }
}
