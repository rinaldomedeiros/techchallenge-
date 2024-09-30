package br.com.fiap.soat8.grp14.techchallenge.adapters.out.persistence.impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import br.com.fiap.soat8.grp14.techchallenge.data.repositories.ClienteRepository;
import br.com.fiap.soat8.grp14.techchallenge.data.repositories.PedidoRepository;
import br.com.fiap.soat8.grp14.techchallenge.data.models.PedidoEntity;
import br.com.fiap.soat8.grp14.techchallenge.presentation.service.PedidoRepositoryPort;
import br.com.fiap.soat8.grp14.techchallenge.core.entities.Pedido;

@Service
@Transactional
public class PedidoRepositoryImpl implements PedidoRepositoryPort {

    private final PedidoRepository pedidoSpringRepository;
    private final ClienteRepository clienteSpringRepository;

    public PedidoRepositoryImpl(PedidoRepository pedidoSpringRepository, ClienteRepository clienteSpringRepository) {
        this.pedidoSpringRepository = pedidoSpringRepository;
		this.clienteSpringRepository = clienteSpringRepository;
    }

    @Override
    public List<Pedido> buscarTodos() {
        List<PedidoEntity> pedidoEntities = this.pedidoSpringRepository.findAll();
        return pedidoEntities.stream().map(PedidoEntity::toPedido).collect(Collectors.toList());
    }

    @Override
    public Pedido salvarPedido(Pedido pedido) {
        PedidoEntity pedidoEntity = new PedidoEntity(pedido);
        pedidoEntity.getItens().forEach(itemPedidoEntity -> itemPedidoEntity.setPedidoEntity(pedidoEntity));
        PedidoEntity pedidoSalvo = pedidoSpringRepository.save(pedidoEntity);
        
        if (pedidoEntity.getClienteEntity() != null && pedidoEntity.getClienteEntity().getId() != null) {
        	pedidoSalvo.setClienteEntity(this.clienteSpringRepository.findById(pedidoEntity.getClienteEntity().getId()).get());
        }
        
        return pedidoSalvo.toPedido();
    }

    @Override
    public Optional<Integer> obterUltimoNumeroPedido() {
        return pedidoSpringRepository.findTopByOrderByNumeroDesc().map(PedidoEntity::getNumero);
    }


}
