package br.com.fiap.soat8.grp14.techchallenge.domain.usecases;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import br.com.fiap.soat8.grp14.techchallenge.adapters.dto.ClienteDTO;
import br.com.fiap.soat8.grp14.techchallenge.application.ports.in.ClienteServicePort;
import br.com.fiap.soat8.grp14.techchallenge.application.ports.out.ClienteRepositoryPort;
import br.com.fiap.soat8.grp14.techchallenge.domain.models.Cliente;
import jakarta.validation.Valid;

@Service
public class ClienteServiceImpl implements ClienteServicePort {
	private ClienteRepositoryPort clienteRepositoryPort;

    public ClienteServiceImpl(ClienteRepositoryPort repository) {
        this.clienteRepositoryPort = repository;
    }

    @Override
    public List<ClienteDTO> listarTodos()  {
        List<Cliente> clientes = clienteRepositoryPort.listarTodos();
        List<ClienteDTO> clienteDTOs = clientes.stream().map(Cliente::toClienteDTO).collect(Collectors.toList());
        return clienteDTOs;
    }

    @Override
    public ClienteDTO buscarCliente(String cpf) {
        Optional<Cliente> cliente = clienteRepositoryPort.buscarCliente(cpf);
        return cliente.map(Cliente::toClienteDTO).orElse(null);
    }
    
    @Override
    public ClienteDTO buscarCliente(Long id) {
    	Optional<Cliente> cliente = clienteRepositoryPort.buscarCliente(id);
        return cliente.map(Cliente::toClienteDTO).orElse(null);
    }

	@Override
	public ClienteDTO salvarCliente(@Valid ClienteDTO clienteDTO) {
		Cliente cliente = new Cliente(clienteDTO);
        Cliente clienteSalvo = clienteRepositoryPort.salvarCliente(cliente);
        return clienteSalvo.toClienteDTO();
	}

	@Override
    public boolean excluirCliente(Long id) {
        Optional<Cliente> clienteOpt = clienteRepositoryPort.buscarCliente(id);
        if (clienteOpt.isPresent()) {
            clienteRepositoryPort.excluirCliente(clienteOpt.get());
            return true;
        }
        return false;
    }

}
