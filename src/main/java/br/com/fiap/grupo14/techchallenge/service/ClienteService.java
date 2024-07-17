package br.com.fiap.grupo14.techchallenge.service;

import br.com.fiap.grupo14.techchallenge.dto.ClienteDTO;
import org.springframework.data.domain.Page;


public interface ClienteService {

    public Page<ClienteDTO> findAll(Integer page, Integer linesPerPage, String orderBy, String direction);

}
