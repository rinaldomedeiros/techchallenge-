package br.com.fiap.soat8.grp14.techchallenge.adapters.out.persistence.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import br.com.fiap.soat8.grp14.techchallenge.adapters.out.persistence.PedidoSpringRepository;
import br.com.fiap.soat8.grp14.techchallenge.adapters.out.persistence.entities.PedidoEntity;
import br.com.fiap.soat8.grp14.techchallenge.application.ports.out.PedidoRepositoryPort;
import br.com.fiap.soat8.grp14.techchallenge.domain.models.Pedido;

@Service
public class PedidoRepositoryImpl implements PedidoRepositoryPort {

    private final PedidoSpringRepository pedidoSpringRepository;

    public PedidoRepositoryImpl(PedidoSpringRepository pedidoSpringRepository) {
        this.pedidoSpringRepository = pedidoSpringRepository;
    }

    @Override
    public List<Pedido> buscarTodos() {
        List<PedidoEntity> pedidoEntities = this.pedidoSpringRepository.findAll();
        return pedidoEntities.stream().map(PedidoEntity::toPedido).collect(Collectors.toList());
    }

    @Override
    public void salvarPedido(Pedido pedido) {
        PedidoEntity pedidoEntity = new PedidoEntity(pedido);
        this.pedidoSpringRepository.save(pedidoEntity);
    }

}
