package br.com.fiap.soat8.grp14.techchallenge.infra.config.beans;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import br.com.fiap.soat8.grp14.techchallenge.core.usecases.pedido.BuscarPedidoUseCase;
import br.com.fiap.soat8.grp14.techchallenge.core.usecases.pedido.CriarPedidoUseCase;
import br.com.fiap.soat8.grp14.techchallenge.core.usecases.pedido.ListarPedidoUseCase;
import br.com.fiap.soat8.grp14.techchallenge.data.repositories.ItemPedidoRepository;
import br.com.fiap.soat8.grp14.techchallenge.data.repositories.PedidoRepository;

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
    public BuscarPedidoUseCase buscarPedidoIdUseCase(PedidoRepository pedidoRepository) {
    	return new BuscarPedidoUseCase(pedidoRepository);
    }
}
