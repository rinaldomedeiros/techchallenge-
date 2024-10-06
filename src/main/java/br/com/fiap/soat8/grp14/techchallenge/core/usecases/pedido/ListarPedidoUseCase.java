package br.com.fiap.soat8.grp14.techchallenge.core.usecases.pedido;

import br.com.fiap.soat8.grp14.techchallenge.core.entities.Pedido;
import br.com.fiap.soat8.grp14.techchallenge.core.interfaces.AbstractUseCase;
import br.com.fiap.soat8.grp14.techchallenge.data.models.PedidoEntity;
import br.com.fiap.soat8.grp14.techchallenge.data.repositories.PedidoRepository;

import java.util.List;

public class ListarPedidoUseCase extends AbstractUseCase<Boolean, List<Pedido>> {

    private final PedidoRepository repository;

    public ListarPedidoUseCase(PedidoRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Pedido> execute(Boolean dummy) {
        List<PedidoEntity> pedidoList = repository.findAll();
        return pedidoList.stream().map(pedido -> getModelMapper().map(pedido, Pedido.class)).toList();
    }
}
