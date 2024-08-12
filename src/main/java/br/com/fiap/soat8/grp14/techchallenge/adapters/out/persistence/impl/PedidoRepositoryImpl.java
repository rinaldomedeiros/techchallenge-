package br.com.fiap.soat8.grp14.techchallenge.adapters.out.persistence.impl;

import br.com.fiap.soat8.grp14.techchallenge.adapters.dto.PedidoDTO;
import br.com.fiap.soat8.grp14.techchallenge.adapters.out.persistence.PedidoSpringRepository;
import br.com.fiap.soat8.grp14.techchallenge.adapters.out.persistence.entities.PedidoEntity;
import br.com.fiap.soat8.grp14.techchallenge.application.ports.out.PedidoRepositoryPort;
import org.springframework.stereotype.Component;

@Component
public class PedidoRepositoryImpl implements PedidoRepositoryPort {

    private final PedidoSpringRepository pedidoSpringRepository;

    public PedidoRepositoryImpl(PedidoSpringRepository pedidoSpringRepository) {
        this.pedidoSpringRepository = pedidoSpringRepository;
    }

    @Override
    public PedidoDTO buscarPorId(Long id) {
        PedidoEntity pedidoEntity = pedidoSpringRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Pedido não encontrado"));
        // Converter PedidoEntity para PedidoDTO
        return new PedidoDTO(pedidoEntity);
    }

    @Override
    public void salvarPedido(PedidoDTO pedido) {
        // Converter PedidoDTO para PedidoEntity
        PedidoEntity pedidoEntity = new PedidoEntity(pedido);
        pedidoSpringRepository.save(pedidoEntity);
    }
}
