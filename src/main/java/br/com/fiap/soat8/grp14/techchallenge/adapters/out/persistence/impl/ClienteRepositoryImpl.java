package br.com.fiap.soat8.grp14.techchallenge.adapters.out.persistence.impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import br.com.fiap.soat8.grp14.techchallenge.adapters.out.persistence.ClienteSpringRepository;
import br.com.fiap.soat8.grp14.techchallenge.adapters.out.persistence.entities.ClienteEntity;
import br.com.fiap.soat8.grp14.techchallenge.application.ports.out.ClienteRepositoryPort;
import br.com.fiap.soat8.grp14.techchallenge.domain.models.Cliente;

@Service
public class ClienteRepositoryImpl implements ClienteRepositoryPort {

    private final ClienteSpringRepository clienteSpringRepository;

    public ClienteRepositoryImpl(ClienteSpringRepository clienteSpringRepository) {
        this.clienteSpringRepository = clienteSpringRepository;
    }

    @Override
    public List<Cliente> listarTodos() {
    	List<ClienteEntity> clientes = this.clienteSpringRepository.findAll();
    	return clientes.stream().map(ClienteEntity::toCliente).collect(Collectors.toList());
    }
    
    @Override
    public Optional<Cliente> buscarCliente(String cpf) {
        Optional<ClienteEntity> clienteEntity = this.clienteSpringRepository.findByCpf(cpf);
        if (clienteEntity.isPresent()) {
            return clienteEntity.map(ClienteEntity::toCliente);
        }
        return Optional.empty();
    }
    
    @Override
    public Optional<Cliente> buscarCliente(Long id) {
    	Optional<ClienteEntity> clienteEntity = this.clienteSpringRepository.findById(id);
    	if (clienteEntity.isPresent()) {
    		return clienteEntity.map(ClienteEntity::toCliente);
    	}
    	return Optional.empty();
    }

	@Override
	public Cliente salvarCliente(Cliente cliente) {
		ClienteEntity clienteEntity = new ClienteEntity(cliente);
        ClienteEntity clienteEntitySalvo = clienteSpringRepository.save(clienteEntity);
        return clienteEntitySalvo.toCliente();		
	}

	@Override
	public void excluirCliente(Cliente cliente) {
		ClienteEntity clienteEntity = new ClienteEntity(cliente);
		clienteSpringRepository.delete(clienteEntity);
	}
    
}
