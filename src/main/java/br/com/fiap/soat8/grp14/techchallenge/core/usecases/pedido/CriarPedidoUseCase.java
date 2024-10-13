package br.com.fiap.soat8.grp14.techchallenge.core.usecases.pedido;


import br.com.fiap.soat8.grp14.techchallenge.core.entities.ItemPedido;
import br.com.fiap.soat8.grp14.techchallenge.core.entities.Pedido;
import br.com.fiap.soat8.grp14.techchallenge.core.entities.enums.StatusPedido;
import br.com.fiap.soat8.grp14.techchallenge.core.interfaces.AbstractUseCase;
import br.com.fiap.soat8.grp14.techchallenge.data.models.ItemPedidoEntity;
import br.com.fiap.soat8.grp14.techchallenge.data.models.PedidoEntity;
import br.com.fiap.soat8.grp14.techchallenge.data.repositories.ItemPedidoRepository;
import br.com.fiap.soat8.grp14.techchallenge.data.repositories.PedidoRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


public class CriarPedidoUseCase extends AbstractUseCase<PedidoEntity, Pedido> {

    private final PedidoRepository repository;
    private final ItemPedidoRepository itemPedidoRepository;


    public CriarPedidoUseCase(PedidoRepository repository, ItemPedidoRepository itemPedidoRepository) {
        this.repository = repository;
        this.itemPedidoRepository = itemPedidoRepository;
    }

    @Override
    public Pedido execute(PedidoEntity pedidoEntity) {
        // Inicialize a lista de itens, caso esteja nula, para evitar NullPointerException
        if (pedidoEntity.getItens() == null || pedidoEntity.getItens().isEmpty()) {
            throw new IllegalArgumentException("A lista de itens não pode ser nula ou vazia.");
        }


        Pedido pedido = getModelMapper().map(pedidoEntity, Pedido.class);

        pedido.setId(null);
        pedido.setValorTotal(this.calcularTotalPedido(pedido.getItens()));
        int numeroPedido = gerarNumeroPedido();
        pedido.setNumero(numeroPedido);
        pedido.setStatusPedido(StatusPedido.RECEBIDO);
        List<ItemPedido> itens = new ArrayList<>(pedido.getItens());
        pedido.setItens(null);

        PedidoEntity pedidoSalvo = repository.save(getModelMapper().map(pedido, PedidoEntity.class));
        itens.forEach(item -> item.setPedido(getModelMapper().map(pedidoSalvo, Pedido.class)));
        List<ItemPedidoEntity> itensEntity = itemPedidoRepository.saveAll(itens.stream().map(item -> getModelMapper().map(item, ItemPedidoEntity.class)).toList());
        pedidoSalvo.setItens(itensEntity);
        return getModelMapper().map(pedidoSalvo, Pedido.class);
    }

    private Double calcularTotalPedido(List<ItemPedido> itens) {

        return itens.stream()
                .mapToDouble(item -> item.getQuantidade() * item.getValorItem())
                .sum();
    }

    private int gerarNumeroPedido() {
        Optional<PedidoEntity> ultimoPedido = repository.findTopByOrderByNumeroDesc();
        return ultimoPedido.map(pedido -> pedido.getNumero() + 1).orElse(1);
    }
}




