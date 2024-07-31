package br.com.fiap.soat8.grp14.techchallenge.application.ports.out;

import br.com.fiap.soat8.grp14.techchallenge.domain.entities.Cliente;

import java.util.List;

public interface ClienteRepositoryPort {
    List<Cliente> listarTodos(Integer page, Integer linesPerPage, String orderBy, String direction);
}
