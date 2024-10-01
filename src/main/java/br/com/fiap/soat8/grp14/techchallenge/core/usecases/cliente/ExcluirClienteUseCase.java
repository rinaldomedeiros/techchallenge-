package br.com.fiap.soat8.grp14.techchallenge.core.usecases.cliente;

import br.com.fiap.soat8.grp14.techchallenge.core.entities.Cliente;
import br.com.fiap.soat8.grp14.techchallenge.core.interfaces.AbstractUseCase;
import br.com.fiap.soat8.grp14.techchallenge.data.models.ClienteEntity;
import br.com.fiap.soat8.grp14.techchallenge.data.repositories.ClienteRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
public class ExcluirClienteUseCase extends AbstractUseCase<Long, Boolean> {

    private final ClienteRepository repository;
    private final BuscarClienteIdUseCase buscarClienteIdUseCase;

    public ExcluirClienteUseCase(ModelMapper mapper, ClienteRepository repository, BuscarClienteIdUseCase buscarClienteIdUseCase) {
        super(mapper);
        this.repository = repository;
        this.buscarClienteIdUseCase = buscarClienteIdUseCase;
    }

    @Override
    public Boolean execute(Long id) {
        Cliente cliente = this.buscarClienteIdUseCase.execute(id);
        repository.delete(mapper.map(cliente, ClienteEntity.class));
        return true;
    }
}
