package br.com.fiap.soat8.grp14.techchallenge.core.usecases.cliente;

import br.com.fiap.soat8.grp14.techchallenge.core.entities.Cliente;
import br.com.fiap.soat8.grp14.techchallenge.core.interfaces.AbstractUseCase;
import br.com.fiap.soat8.grp14.techchallenge.data.models.ClienteEntity;
import br.com.fiap.soat8.grp14.techchallenge.data.repositories.ClienteRepository;
import org.modelmapper.ModelMapper;

import java.util.List;

public class ListarClienteUseCase extends AbstractUseCase<Boolean, List<Cliente>> {

    private final ClienteRepository repository;

    public ListarClienteUseCase(ModelMapper mapper, ClienteRepository repository) {
        super(mapper);
        this.repository = repository;
    }

    @Override
    public List<Cliente> execute(Boolean dummy) {
        List<ClienteEntity> clientesList = repository.findAll();
        return clientesList.stream().map(cliente -> mapper.map(cliente, Cliente.class)).toList();
    }
}
