package br.com.fiap.soat8.grp14.techchallenge.core.usecases.cliente;

import br.com.fiap.soat8.grp14.techchallenge.app.exceptions.DataIntegrityException;
import br.com.fiap.soat8.grp14.techchallenge.core.entities.Cliente;
import br.com.fiap.soat8.grp14.techchallenge.core.interfaces.AbstractUseCase;
import br.com.fiap.soat8.grp14.techchallenge.data.models.ClienteEntity;
import br.com.fiap.soat8.grp14.techchallenge.data.repositories.ClienteRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CriarClienteUseCase extends AbstractUseCase<ClienteEntity, Cliente> {

    private static final String CPF_CADASTRADO = "CPF já cadastrado.";

    private final ClienteRepository repository;


    public CriarClienteUseCase(ClienteRepository repository) {
        this.repository = repository;
    }

    @Override
    public Cliente execute(ClienteEntity clienteEntity) {
        Optional<ClienteEntity> clienteExistente = repository.findByCpf(clienteEntity.getCpf());
        if (clienteExistente.isPresent()) {
            throw new DataIntegrityException(CPF_CADASTRADO);
        }

        ClienteEntity clienteSalvo = repository.save(clienteEntity);
        return getModelMapper().map(clienteSalvo, Cliente.class);
    }
}
