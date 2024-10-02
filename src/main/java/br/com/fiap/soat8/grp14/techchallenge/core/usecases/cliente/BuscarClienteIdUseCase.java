package br.com.fiap.soat8.grp14.techchallenge.core.usecases.cliente;

import br.com.fiap.soat8.grp14.techchallenge.app.exceptions.DataIntegrityException;
import br.com.fiap.soat8.grp14.techchallenge.core.entities.Cliente;
import br.com.fiap.soat8.grp14.techchallenge.core.interfaces.AbstractUseCase;
import br.com.fiap.soat8.grp14.techchallenge.data.models.ClienteEntity;
import br.com.fiap.soat8.grp14.techchallenge.data.repositories.ClienteRepository;

import java.util.Optional;


public class BuscarClienteIdUseCase extends AbstractUseCase<Long, Cliente> {
    private static final String ID_NAO_ENCONTRADO = "Cliente não encontrado";

    private final ClienteRepository repository;

    public BuscarClienteIdUseCase(ClienteRepository repository) {
        this.repository = repository;
    }

    @Override
    public Cliente execute(Long id) {
        Optional<ClienteEntity> clienteEntity =  this.repository.findById(id);
        if (clienteEntity.isEmpty()) {
            throw new DataIntegrityException(ID_NAO_ENCONTRADO);
        }

        return getModelMapper().map(clienteEntity.get(), Cliente.class);
    }
}
