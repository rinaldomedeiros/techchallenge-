package br.com.fiap.soat8.grp14.techchallenge.infra.config;

import br.com.fiap.soat8.grp14.techchallenge.application.ports.in.ProdutoServicePort;
import br.com.fiap.soat8.grp14.techchallenge.presentation.service.ProdutoRepositoryPort;
import br.com.fiap.soat8.grp14.techchallenge.core.usecases.ProdutoServiceImpl;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import br.com.fiap.soat8.grp14.techchallenge.application.ports.in.PedidoServicePort;
import br.com.fiap.soat8.grp14.techchallenge.presentation.service.PedidoRepositoryPort;
import br.com.fiap.soat8.grp14.techchallenge.core.usecases.PedidoServiceImpl;

@Configuration
public class BeanConfiguration {

    @Bean
    ProdutoServicePort produtoService(ProdutoRepositoryPort produtoRepositoryPort) {
        return new ProdutoServiceImpl(produtoRepositoryPort);
    }

    @Bean
    PedidoServicePort pedidoService(PedidoRepositoryPort pedidoRepositoryPort) {
        return new PedidoServiceImpl(pedidoRepositoryPort);
    }
}
