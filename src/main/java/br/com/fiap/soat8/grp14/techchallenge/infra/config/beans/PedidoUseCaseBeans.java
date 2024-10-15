package br.com.fiap.soat8.grp14.techchallenge.infra.config.beans;

import br.com.fiap.soat8.grp14.techchallenge.core.usecases.pedido.*;
import br.com.fiap.soat8.grp14.techchallenge.data.repositories.ItemPedidoRepository;
import br.com.fiap.soat8.grp14.techchallenge.data.repositories.PedidoRepository;
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
    public AtualizarStatusPedidoUseCase atualizarStatusPedidoUseCase(PedidoRepository pedidoRepository) {
        return new AtualizarStatusPedidoUseCase(pedidoRepository);
    }

    @Bean
    public BuscarPedidoUseCase buscarPedidoUseCase(PedidoRepository pedidoRepository) {
        return new BuscarPedidoUseCase(pedidoRepository);
    }

    @Bean
    public ListarPedidoOrdenadoUseCase listarPedidoOrdenadoUseCase(PedidoRepository pedidoRepository) {
        return new ListarPedidoOrdenadoUseCase(pedidoRepository);
    }
}
