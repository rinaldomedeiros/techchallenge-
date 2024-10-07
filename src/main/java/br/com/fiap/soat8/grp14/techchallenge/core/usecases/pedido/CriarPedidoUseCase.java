package br.com.fiap.soat8.grp14.techchallenge.core.usecases.pedido;

import br.com.fiap.soat8.grp14.techchallenge.app.dto.itempedido.ItemPedidoDTO;
import br.com.fiap.soat8.grp14.techchallenge.core.entities.Pedido;
import br.com.fiap.soat8.grp14.techchallenge.core.interfaces.AbstractUseCase;
import br.com.fiap.soat8.grp14.techchallenge.data.models.ItemPedidoEntity;
import br.com.fiap.soat8.grp14.techchallenge.data.models.PedidoEntity;
import br.com.fiap.soat8.grp14.techchallenge.data.repositories.PedidoRepository;
import java.util.List;


public class CriarPedidoUseCase extends AbstractUseCase<PedidoEntity, Pedido> {

    private final PedidoRepository repository;

    public CriarPedidoUseCase(PedidoRepository repository) {
        this.repository = repository;
    }


    @Override
    public Pedido execute(PedidoEntity pedidoEntity)  {


        PedidoEntity pedidoSalvo = repository.save(pedidoEntity);
        return getModelMapper().map(pedidoSalvo, Pedido.class);
    }

//    private Double calcularTotalPedido(List<ItemPedidoEntity> itens) {
//        for (ItemPedidoEntity item : itens) {
//            item.setValorItem(item.getValorItem());
//        }
//
//        return itens.stream()
//                .mapToDouble(item -> item.getQuantidade() * item.getValorItem())
//                .sum();
//    }

//    private int gerarNumeroPedido() {
//        Optional<Integer> ultimoNumero = pedidoRepositoryPort.obterUltimoNumeroPedido();
//
//        // Se existe um número anterior, incrementa, senão começa com 1
//        int novoNumero = ultimoNumero.orElse(0) + 1;
//
//        if (novoNumero > 1000) {
//            novoNumero = 1;
//        }
//        return novoNumero;
//    }


}



