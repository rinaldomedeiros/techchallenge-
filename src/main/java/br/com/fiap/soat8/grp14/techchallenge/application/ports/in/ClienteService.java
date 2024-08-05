package br.com.fiap.soat8.grp14.techchallenge.application.ports.in;

import br.com.fiap.soat8.grp14.techchallenge.adapters.dto.ClienteDTO;

import java.util.List;


public interface ClienteService {

    List<ClienteDTO> listarTodos(Integer page, Integer linesPerPage, String orderBy, String direction);

}
