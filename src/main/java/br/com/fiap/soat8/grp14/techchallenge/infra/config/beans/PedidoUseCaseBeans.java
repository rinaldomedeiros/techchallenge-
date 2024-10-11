package br.com.fiap.soat8.grp14.techchallenge.infra.config.beans;

import br.com.fiap.soat8.grp14.techchallenge.core.entities.Pedido;
import br.com.fiap.soat8.grp14.techchallenge.core.usecases.pedido.AtualizarStatusPedidoUseCase;
import br.com.fiap.soat8.grp14.techchallenge.core.usecases.pedido.CriarPedidoUseCase;
import br.com.fiap.soat8.grp14.techchallenge.core.usecases.pedido.ListarPedidoUseCase;
import br.com.fiap.soat8.grp14.techchallenge.data.repositories.ItemPedidoRepository;
import br.com.fiap.soat8.grp14.techchallenge.data.repositories.PedidoRepository;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class PedidoUseCaseBeans {

    @Bean
    public ListarPedidoUseCase listarPedidoUseCase(PedidoRepository pedidoRepository) {
        return new ListarPedidoUseCase(pedidoRepository);
    }

    @Bean
    public CriarPedidoUseCase criarPedidoUseCase(PedidoRepository pedidoRepository, ItemPedidoRepository itemPedidoRepository) {
        return new CriarPedidoUseCase(pedidoRepository, itemPedidoRepository);
    }

    @Bean
    public AtualizarStatusPedidoUseCase atualizarStatusPedidoUseCase(PedidoRepository pedidoRepository, ModelMapper modelMapper) {
        return new AtualizarStatusPedidoUseCase(pedidoRepository, modelMapper);
    }
}
