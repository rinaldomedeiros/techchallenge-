package br.com.fiap.soat8.grp14.techchallenge.app.services;

import br.com.fiap.soat8.grp14.techchallenge.app.dto.cliente.ClienteDTO;
import br.com.fiap.soat8.grp14.techchallenge.app.dto.cliente.ClienteInsertDTO;
import br.com.fiap.soat8.grp14.techchallenge.core.usecases.cliente.*;
import br.com.fiap.soat8.grp14.techchallenge.data.models.ClienteEntity;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@AllArgsConstructor
public class ClienteService {
    private final CriarClienteUseCase criarClienteUseCase;
    private final BuscarClienteCpfUseCase buscarClienteCpfUseCase;
    private final ListarClienteUseCase listarClienteUseCase;
    private final BuscarClienteIdUseCase buscarClienteIdUseCase;
    private final ExcluirClienteUseCase excluirClienteUseCase;
    private final AtualizarClienteUseCase atualizarClienteUseCase;

    private final ModelMapper mapper;

    @Transactional
    public CriarClienteUseCase criarCliente(ClienteDTO clienteDTO) {
        return criarClienteUseCase;
    }

    public List<ClienteDTO> listarTodos(){
        return this.listarClienteUseCase.execute(true).stream().map(cliente -> mapper.map(cliente, ClienteDTO.class)).toList();
    }

    public ClienteDTO buscarCliente(String cpf){
        return mapper.map(this.buscarClienteCpfUseCase.execute(cpf), ClienteDTO.class);
    }

    public ClienteDTO buscarClienteId(Long id){
        return mapper.map(this.buscarClienteIdUseCase.execute(id), ClienteDTO.class);
    }

    @Transactional
    public ClienteDTO salvarCliente(@Valid ClienteInsertDTO clienteInsertDTO){
        return mapper.map(this.criarClienteUseCase.execute(mapper.map(clienteInsertDTO, ClienteEntity.class)), ClienteDTO.class) ;
    }

    public void excluirCliente(Long id){
        this.excluirClienteUseCase.execute(id);
    }

    @Transactional
    public ClienteDTO atualizarCliente(Long id, ClienteDTO clienteDTO){
        return mapper.map(this.atualizarClienteUseCase.execute(mapper.map(clienteDTO, ClienteEntity.class)), ClienteDTO.class);
    }
}
