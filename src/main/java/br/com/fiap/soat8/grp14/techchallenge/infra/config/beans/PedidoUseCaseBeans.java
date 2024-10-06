package br.com.fiap.soat8.grp14.techchallenge.infra.config.beans;

import br.com.fiap.soat8.grp14.techchallenge.core.usecases.pedido.ListarPedidoUseCase;
import br.com.fiap.soat8.grp14.techchallenge.data.repositories.PedidoRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class PedidoUseCaseBeans {

    @Bean
    public ListarPedidoUseCase listarPedidoUseCase(PedidoRepository pedidoRepository) {
        return new ListarPedidoUseCase(pedidoRepository);
    }
}
