package br.com.fiap.soat8.grp14.techchallenge.core.usecases.cliente;

import br.com.fiap.soat8.grp14.techchallenge.app.exceptions.EntityNotFoundException;
import br.com.fiap.soat8.grp14.techchallenge.core.entities.Cliente;
import br.com.fiap.soat8.grp14.techchallenge.core.interfaces.AbstractUseCase;
import br.com.fiap.soat8.grp14.techchallenge.data.models.ClienteEntity;
import br.com.fiap.soat8.grp14.techchallenge.data.repositories.ClienteRepository;

public class AtualizarClienteUseCase extends AbstractUseCase<ClienteEntity, Cliente> {

    private static final String CLIENTE_NAO_ENCONTRADO = "Cliente não encontrado";

    private final ClienteRepository repository;

    public AtualizarClienteUseCase(ClienteRepository repository) {
        this.repository = repository;
    }

    @Override
    public Cliente execute(ClienteEntity clienteEntity) {
        repository.findById(
                clienteEntity.getId()).orElseThrow(() -> new EntityNotFoundException(CLIENTE_NAO_ENCONTRADO)
        );

        return getModelMapper().map(this.repository.save(clienteEntity), Cliente.class);
    }
}
