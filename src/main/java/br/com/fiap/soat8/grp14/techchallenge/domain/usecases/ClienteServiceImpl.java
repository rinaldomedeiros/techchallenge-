package br.com.fiap.soat8.grp14.techchallenge.domain.usecases;

import java.util.List;

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
        return clientes.stream().map(Cliente::toClienteDTO).toList();
    }

    @Override
    public ClienteDTO buscarCliente(String cpf) {
        Cliente cliente = clienteRepositoryPort.buscarCliente(cpf);
        return cliente.toClienteDTO();
    }
    
    @Override
    public ClienteDTO buscarCliente(Long id) {
    	Cliente cliente = clienteRepositoryPort.buscarCliente(id);
        return cliente.toClienteDTO();
    }

	@Override
	public ClienteDTO salvarCliente(@Valid ClienteDTO clienteDTO) {
		Cliente cliente = new Cliente(clienteDTO);
        Cliente clienteSalvo = clienteRepositoryPort.salvarCliente(cliente);
        return clienteSalvo.toClienteDTO();
	}

	@Override
    public void excluirCliente(Long id) {
        Cliente cliente = clienteRepositoryPort.buscarCliente(id);
        clienteRepositoryPort.excluirCliente(cliente);
    }

}
