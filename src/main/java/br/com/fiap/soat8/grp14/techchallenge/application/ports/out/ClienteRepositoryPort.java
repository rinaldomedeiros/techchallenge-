package br.com.fiap.soat8.grp14.techchallenge.application.ports.out;

import br.com.fiap.soat8.grp14.techchallenge.adapters.out.persistence.entities.ClienteEntity;

import java.util.List;

public interface ClienteRepositoryPort {
    List<ClienteEntity> listarTodos(Integer page, Integer linesPerPage, String orderBy, String direction);
}
