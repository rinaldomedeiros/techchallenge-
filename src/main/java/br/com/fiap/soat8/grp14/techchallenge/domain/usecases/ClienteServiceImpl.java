package br.com.fiap.soat8.grp14.techchallenge.domain.usecases;

import br.com.fiap.soat8.grp14.techchallenge.adapters.dto.ClienteDTO;
import br.com.fiap.soat8.grp14.techchallenge.application.ports.in.ClienteService;
import br.com.fiap.soat8.grp14.techchallenge.application.ports.out.ClienteRepositoryPort;
import br.com.fiap.soat8.grp14.techchallenge.domain.entities.Cliente;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ClienteServiceImpl implements ClienteService {
    @Autowired
    private ModelMapper modelMapper;

    private ClienteRepositoryPort repository;

    public ClienteServiceImpl(ClienteRepositoryPort repository) {
        this.repository = repository;
    }

    public List<ClienteDTO> listarTodos(Integer page, Integer linesPerPage, String orderBy, String direction)  {
        List<Cliente> resultado = repository.listarTodos(page, linesPerPage, orderBy, direction);
        return resultado.stream().map((element) -> modelMapper.map(element, ClienteDTO.class)).collect(Collectors.toList());
    }

}
