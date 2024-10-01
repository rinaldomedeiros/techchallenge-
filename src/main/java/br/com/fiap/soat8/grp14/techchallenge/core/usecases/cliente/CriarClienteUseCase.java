package br.com.fiap.soat8.grp14.techchallenge.core.usecases.cliente;

import br.com.fiap.soat8.grp14.techchallenge.app.exceptions.DataIntegrityException;
import br.com.fiap.soat8.grp14.techchallenge.core.entities.Cliente;
import br.com.fiap.soat8.grp14.techchallenge.core.interfaces.AbstractUseCase;
import br.com.fiap.soat8.grp14.techchallenge.data.models.ClienteEntity;
import br.com.fiap.soat8.grp14.techchallenge.data.repositories.ClienteRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CriarClienteUseCase extends AbstractUseCase<ClienteEntity, Cliente> {

    private static final String CPF_CADASTRADO = "CPF já cadastrado.";

    private final ClienteRepository repository;


    protected CriarClienteUseCase(ModelMapper mapper, ClienteRepository repository) {
        super(mapper);
        this.repository = repository;
    }

    @Override
    public Cliente execute(ClienteEntity clienteEntity) {
        Optional<ClienteEntity> clienteExistente = repository.findByCpf(clienteEntity.getCpf());
        if (clienteExistente.isEmpty()) {
            throw new DataIntegrityException(CPF_CADASTRADO);
        }

        ClienteEntity clienteSalvo = repository.save(clienteEntity);
        return mapper.map(clienteSalvo, Cliente.class);
    }
}
