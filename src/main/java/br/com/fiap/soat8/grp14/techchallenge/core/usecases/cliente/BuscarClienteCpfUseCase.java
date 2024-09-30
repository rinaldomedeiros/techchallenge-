package br.com.fiap.soat8.grp14.techchallenge.core.usecases.cliente;

import br.com.fiap.soat8.grp14.techchallenge.app.exceptions.DataIntegrityException;
import br.com.fiap.soat8.grp14.techchallenge.core.entities.Cliente;
import br.com.fiap.soat8.grp14.techchallenge.core.interfaces.AbstractUseCase;
import br.com.fiap.soat8.grp14.techchallenge.data.models.ClienteEntity;
import br.com.fiap.soat8.grp14.techchallenge.data.repositories.ClienteRepository;
import org.modelmapper.ModelMapper;

import java.util.Optional;

public class BuscarClienteCpfUseCase extends AbstractUseCase<String, Cliente> {
    private static final String CPF_NAO_ENCONTRADO = "CPF não encontrado.";

    private final ClienteRepository repository;

    public BuscarClienteCpfUseCase(ModelMapper mapper, ClienteRepository repository) {
        super(mapper);
        this.repository = repository;
    }

    @Override
    public Cliente execute(String cpf) {
        Optional<ClienteEntity> clienteEntity =  this.repository.findByCpf(cpf);
        if (clienteEntity.isEmpty()) {
            throw new DataIntegrityException(CPF_NAO_ENCONTRADO);
        }

        return mapper.map(clienteEntity.get(), Cliente.class);
    }
}
