package br.com.fiap.soat8.grp14.techchallenge.core.usecases.pedido;

import br.com.fiap.soat8.grp14.techchallenge.core.entities.Pedido;
import br.com.fiap.soat8.grp14.techchallenge.core.entities.enums.StatusPedido;
import br.com.fiap.soat8.grp14.techchallenge.core.interfaces.AbstractUseCase;
import br.com.fiap.soat8.grp14.techchallenge.data.models.PedidoEntity;
import br.com.fiap.soat8.grp14.techchallenge.data.repositories.PedidoRepository;
import jakarta.transaction.Transactional;

import java.lang.reflect.Field;
import java.time.LocalDateTime;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class ListarPedidoOrdenadoUseCase extends AbstractUseCase<Boolean, List<Pedido>> {


    private final PedidoRepository repository;

    public ListarPedidoOrdenadoUseCase(PedidoRepository repository) {
        this.repository = repository;
    }

    @Override
    @Transactional
    public List<Pedido> execute(Boolean dummy) {
        List<PedidoEntity> pedidoList = repository.findAll();

        return pedidoList.stream()
                .filter(pedido -> !getStatusField(pedido).equals(StatusPedido.FINALIZADO)) // Exclui pedidos com status "Finalizado"
                .sorted(Comparator.comparing((PedidoEntity pedido) -> getStatusPriority(getStatusField(pedido))) // Ordena por prioridade do status
                        .thenComparing((PedidoEntity pedido) -> getDataCriacaoField(pedido), Comparator.naturalOrder())) // Ordena do mais novo para o mais antigo
                .map(pedido -> getModelMapper().map(pedido, Pedido.class))
                .collect(Collectors.toList());
    }

    private StatusPedido getStatusField(PedidoEntity pedido) {
        try {
            Field statusField = PedidoEntity.class.getDeclaredField("statusPedido");
            statusField.setAccessible(true);
            return (StatusPedido) statusField.get(pedido);
        } catch (NoSuchFieldException | IllegalAccessException e) {
            throw new RuntimeException("Erro ao acessar o campo status", e);
        }
    }

    private int getStatusPriority(StatusPedido status) {
        switch (status) {
            case PRONTO:
                return 1;
            case EM_PREPARACAO:
                return 2;
            case RECEBIDO:
                return 3;
            default:
                throw new IllegalStateException("Unexpected status: " + status);
        }
    }

    private LocalDateTime getDataCriacaoField(PedidoEntity pedido) {
        try {
            Field dataCriacaoField = PedidoEntity.class.getDeclaredField("dataPedido");
            dataCriacaoField.setAccessible(true);
            return (LocalDateTime) dataCriacaoField.get(pedido);
        } catch (NoSuchFieldException | IllegalAccessException e) {
            throw new RuntimeException("Erro ao acessar o campo dataCriacao", e);
        }
    }


}
