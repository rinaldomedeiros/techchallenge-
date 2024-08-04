package br.com.fiap.soat8.grp14.techchallenge.config;

import br.com.fiap.soat8.grp14.techchallenge.application.ports.in.ProdutoService;
import br.com.fiap.soat8.grp14.techchallenge.application.ports.out.ProdutoRepositoryPort;
import br.com.fiap.soat8.grp14.techchallenge.domain.usecases.ProdutoServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfiguration {

    @Bean
    ProdutoService produtoService(ProdutoRepositoryPort produtoRepositoryPort) {
        return new ProdutoServiceImpl(produtoRepositoryPort);
    }
}
