package br.com.fiap.soat8.grp14.techchallenge.infra.config.beans;

import br.com.fiap.soat8.grp14.techchallenge.core.usecases.cliente.*;
import br.com.fiap.soat8.grp14.techchallenge.data.repositories.ClienteRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ClienteUseCaseBeans {

    @Bean
    public BuscarClienteCpfUseCase buscarClienteCpfUseCase(ClienteRepository clienteRepository) {
        return new BuscarClienteCpfUseCase(clienteRepository);
    }

    @Bean
    public BuscarClienteIdUseCase buscarClienteIdUseCase(ClienteRepository clienteRepository) {
        return new BuscarClienteIdUseCase(clienteRepository);
    }

    @Bean
    public AtualizarClienteUseCase atualizarClienteUseCase(ClienteRepository clienteRepository) {
        return new AtualizarClienteUseCase(clienteRepository);
    }

    @Bean
    public CriarClienteUseCase criarClienteUseCase(ClienteRepository clienteRepository) {
        return new CriarClienteUseCase(clienteRepository);
    }

    @Bean
    public ExcluirClienteUseCase excluirClienteUseCase(ClienteRepository clienteRepository, BuscarClienteIdUseCase buscarClienteIdUseCase) {
        return new ExcluirClienteUseCase(clienteRepository, buscarClienteIdUseCase);
    }

    @Bean
    public ListarClienteUseCase listarClienteUseCase(ClienteRepository clienteRepository) {
        return new ListarClienteUseCase(clienteRepository);
    }
}
