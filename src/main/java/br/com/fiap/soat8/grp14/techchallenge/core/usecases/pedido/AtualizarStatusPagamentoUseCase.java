package br.com.fiap.soat8.grp14.techchallenge.core.usecases.pedido;

import br.com.fiap.soat8.grp14.techchallenge.app.dto.pedido.PedidoStatusPagamentoDTO;
import br.com.fiap.soat8.grp14.techchallenge.app.exceptions.EntityNotFoundException;
import br.com.fiap.soat8.grp14.techchallenge.core.entities.Pedido;
import br.com.fiap.soat8.grp14.techchallenge.core.interfaces.AbstractUseCase;
import br.com.fiap.soat8.grp14.techchallenge.data.models.PedidoEntity;
import br.com.fiap.soat8.grp14.techchallenge.data.repositories.PedidoRepository;

public class AtualizarStatusPagamentoUseCase extends AbstractUseCase<PedidoStatusPagamentoDTO, Pedido> {

    private static final String PEDIDO_NAO_ENCONTRADO = "Pedido não encontrado";

    private final PedidoRepository pedidoRepository;

    public AtualizarStatusPagamentoUseCase(PedidoRepository pedidoRepository) {
        this.pedidoRepository = pedidoRepository;
    }

    @Override
    public Pedido execute(PedidoStatusPagamentoDTO pedidoStatusPagamentoDTO) {
        PedidoEntity pedidoEntity = pedidoRepository.findById(pedidoStatusPagamentoDTO.getPedidoId())
                .orElseThrow(() -> new EntityNotFoundException(PEDIDO_NAO_ENCONTRADO));

        pedidoEntity.setStatusPagamento(pedidoStatusPagamentoDTO.getStatusPagamento());

        return getModelMapper().map(this.pedidoRepository.save(pedidoEntity), Pedido.class);
    }
}

