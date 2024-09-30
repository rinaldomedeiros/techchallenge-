package br.com.fiap.soat8.grp14.techchallenge.adapters.out.persistence.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import br.com.fiap.soat8.grp14.techchallenge.data.repositories.ClienteRepository;
import br.com.fiap.soat8.grp14.techchallenge.data.repositories.PedidoRepository;
import br.com.fiap.soat8.grp14.techchallenge.data.models.ClienteEntity;
import br.com.fiap.soat8.grp14.techchallenge.data.models.PedidoEntity;
import br.com.fiap.soat8.grp14.techchallenge.presentation.service.ClienteRepositoryPort;
import br.com.fiap.soat8.grp14.techchallenge.app.exceptions.EntityNotFoundException;
import br.com.fiap.soat8.grp14.techchallenge.core.entities.Cliente;

@Service
public class ClienteRepositoryImpl implements ClienteRepositoryPort {

    private final ClienteRepository clienteSpringRepository;
    private final PedidoRepository pedidoSpringRepository;

    public ClienteRepositoryImpl(ClienteRepository clienteSpringRepository, PedidoRepository pedidoSpringRepository) {
        this.clienteSpringRepository = clienteSpringRepository;
        this.pedidoSpringRepository = pedidoSpringRepository;
    }

    @Override
    public List<Cliente> listarTodos() {
        List<ClienteEntity> clientes = this.clienteSpringRepository.findAll();
        return clientes.stream().map(ClienteEntity::toCliente).toList();
    }

    @Override
    public Cliente buscarCliente(String cpf) {
        Optional<ClienteEntity> cliente = this.clienteSpringRepository.findByCpf(cpf);
        if(cliente.isPresent()) {
        	return cliente.get().toCliente();
        }
        return null; 
    }


    @Override
    public Cliente buscarCliente(Long id) {
        return this.clienteSpringRepository.findById(id)
                .map(ClienteEntity::toCliente)
                .orElseThrow(this::lancarException);
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
        removeRelacionamentoCliente(cliente.getId());
        clienteSpringRepository.delete(clienteEntity);
    }

    @Override
    public Cliente atualizarCliente(Long id, Cliente cliente) {
        ClienteEntity clienteExistente = clienteSpringRepository.
                findById(id).orElseThrow(() -> new EntityNotFoundException("Cliente não encontrado"));
        clienteExistente.setNome(cliente.getNome());
        clienteExistente.setCpf(cliente.getCpf());
        clienteExistente.setEmail(cliente.getEmail());

        this.clienteSpringRepository.save(clienteExistente);
        return cliente;
    }

    private void removeRelacionamentoCliente(Long idCliente) {
        List<PedidoEntity> pedidos = pedidoSpringRepository.findByClienteEntity_Id(idCliente);
        for (PedidoEntity pedido : pedidos) {
            pedido.setClienteEntity(null);
        }
        pedidoSpringRepository.saveAllAndFlush(pedidos);
    }

    private EntityNotFoundException lancarException() {
        return new EntityNotFoundException("Cliente não encontrado");
    }
}
