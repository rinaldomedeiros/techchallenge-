package br.com.fiap.soat8.grp14.techchallenge.core.usecases;

import br.com.fiap.soat8.grp14.techchallenge.app.dto.cliente.ClienteDTO;
import br.com.fiap.soat8.grp14.techchallenge.application.ports.in.ClienteServicePort;
import br.com.fiap.soat8.grp14.techchallenge.core.entities.Cliente;
import br.com.fiap.soat8.grp14.techchallenge.presentation.service.ClienteRepositoryPort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteServiceImpl implements ClienteServicePort {
    private ClienteRepositoryPort clienteRepositoryPort;

    public ClienteServiceImpl(ClienteRepositoryPort repository) {
        this.clienteRepositoryPort = repository;
    }

    @Override
    public List<ClienteDTO> listarTodos() {
        List<Cliente> clientes = clienteRepositoryPort.listarTodos();
        return clientes.stream().map(Cliente::toClienteDTO).toList();
    }

}
