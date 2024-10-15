package br.com.fiap.soat8.grp14.techchallenge.core.usecases.pedido;

import br.com.fiap.soat8.grp14.techchallenge.app.exceptions.EntityNotFoundException;
import br.com.fiap.soat8.grp14.techchallenge.core.entities.Pedido;
import br.com.fiap.soat8.grp14.techchallenge.core.interfaces.AbstractUseCase;
import br.com.fiap.soat8.grp14.techchallenge.data.models.PedidoEntity;
import br.com.fiap.soat8.grp14.techchallenge.data.repositories.PedidoRepository;

public class BuscarPedidoUseCase extends AbstractUseCase<Long, Pedido> {

    private static final String PEDIDO_NAO_ENCONTRADO = "Pedido não encontrado";

    private final PedidoRepository repository;

    public BuscarPedidoUseCase(PedidoRepository repository) {
        this.repository = repository;
    }

    @Override
    public Pedido execute(Long idPedido) {
        PedidoEntity pedidoEntity = repository.findById(idPedido)
                .orElseThrow(() -> new EntityNotFoundException(PEDIDO_NAO_ENCONTRADO));

        return getModelMapper().map(pedidoEntity, Pedido.class);
    }

}
