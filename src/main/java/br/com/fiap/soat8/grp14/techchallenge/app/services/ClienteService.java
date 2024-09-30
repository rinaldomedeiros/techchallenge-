package br.com.fiap.soat8.grp14.techchallenge.app.services;

import br.com.fiap.soat8.grp14.techchallenge.app.dto.cliente.ClienteDTO;
import br.com.fiap.soat8.grp14.techchallenge.core.usecases.cliente.BuscarClienteCpfUseCase;
import br.com.fiap.soat8.grp14.techchallenge.core.usecases.cliente.CriarClienteUseCase;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@AllArgsConstructor
public class ClienteService {
    private final CriarClienteUseCase criarClienteUseCase;
    private final BuscarClienteCpfUseCase buscarClienteCpfUseCase;
    private final ModelMapper modelMapper;

    @Transactional
    public CriarClienteUseCase criarCliente(ClienteDTO clienteDTO) {

        return criarClienteUseCase;
    }
}
