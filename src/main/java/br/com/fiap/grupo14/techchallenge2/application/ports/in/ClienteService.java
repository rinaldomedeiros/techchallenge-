package br.com.fiap.grupo14.techchallenge2.application.ports.in;

import org.springframework.data.domain.Page;

import br.com.fiap.grupo14.techchallenge2.adapter.dto.ClienteDTO;


public interface ClienteService {

    public Page<ClienteDTO> findAll(Integer page, Integer linesPerPage, String orderBy, String direction);

}
