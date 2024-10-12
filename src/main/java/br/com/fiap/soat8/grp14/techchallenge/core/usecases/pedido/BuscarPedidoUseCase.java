package br.com.fiap.soat8.grp14.techchallenge.core.usecases.pedido;

import br.com.fiap.soat8.grp14.techchallenge.app.exceptions.DataIntegrityException;
import br.com.fiap.soat8.grp14.techchallenge.core.entities.Pedido;
import br.com.fiap.soat8.grp14.techchallenge.core.interfaces.AbstractUseCase;
import br.com.fiap.soat8.grp14.techchallenge.data.models.PedidoEntity;
import br.com.fiap.soat8.grp14.techchallenge.data.repositories.PedidoRepository;

public class BuscarPedidoUseCase extends AbstractUseCase<Integer, Pedido> {

    private static final String NAO_ENCONTRADO = "Pedido não encontrado";

    private final PedidoRepository repository;

    public BuscarPedidoUseCase(PedidoRepository repository) {
        this.repository = repository;
    }

    @Override
    public Pedido execute(Integer nrPedido) {
        PedidoEntity pedido = repository.findByNumero(nrPedido);

        if (pedido == null) {
            throw new DataIntegrityException(NAO_ENCONTRADO);
        }

        return getModelMapper().map(pedido, Pedido.class);

    }

}
