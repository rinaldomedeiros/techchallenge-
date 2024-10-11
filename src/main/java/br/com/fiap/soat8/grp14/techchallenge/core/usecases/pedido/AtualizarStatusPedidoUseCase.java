package br.com.fiap.soat8.grp14.techchallenge.core.usecases.pedido;

import br.com.fiap.soat8.grp14.techchallenge.app.exceptions.EntityNotFoundException;
import br.com.fiap.soat8.grp14.techchallenge.core.entities.Pedido;
import br.com.fiap.soat8.grp14.techchallenge.core.entities.enums.StatusPedido;
import br.com.fiap.soat8.grp14.techchallenge.core.interfaces.AbstractUseCase;
import br.com.fiap.soat8.grp14.techchallenge.data.models.PedidoEntity;
import br.com.fiap.soat8.grp14.techchallenge.data.repositories.PedidoRepository;
import org.modelmapper.ModelMapper;

public class AtualizarStatusPedidoUseCase {


    private static final String PEDIDO_NAO_ENCONTRADO = "Pedido não encontrado";

    private final PedidoRepository pedidoRepository;

    private final ModelMapper modelMapper;

    public AtualizarStatusPedidoUseCase(PedidoRepository pedidoRepository, ModelMapper modelMapper) {
        this.pedidoRepository = pedidoRepository;
        this.modelMapper = modelMapper;
    }

    public ModelMapper getModelMapper() {
        return modelMapper;
    }

    public Pedido executeCustom(Integer numeroPedido, StatusPedido status) {

        PedidoEntity pedidoEntity = pedidoRepository.findByNumero(numeroPedido)
                .orElseThrow(() -> new EntityNotFoundException(PEDIDO_NAO_ENCONTRADO));

        pedidoEntity.setStatusPedido(status);


        return getModelMapper().map(this.pedidoRepository.save(pedidoEntity), Pedido.class);
    }
}

