package br.com.fiap.soat8.grp14.techchallenge.adapter.out.persistence.impl;

import br.com.fiap.soat8.grp14.techchallenge.adapter.out.persistence.ClienteSpringRepository;
import br.com.fiap.soat8.grp14.techchallenge.application.ports.out.ClienteRepositoryPort;
import br.com.fiap.soat8.grp14.techchallenge.domain.entities.Cliente;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteRepositoryImpl implements ClienteRepositoryPort {

    private final ClienteSpringRepository clienteSpringRepository;
    private EntityManager manager;

    public ClienteRepositoryImpl(ClienteSpringRepository clienteSpringRepository) {
        this.clienteSpringRepository = clienteSpringRepository;
    }

    @PersistenceContext
    public void setManager(EntityManager manager) {
        this.manager = manager;
    }


    @Override
    public List<Cliente> listarTodos(Integer page, Integer linesPerPage, String orderBy, String direction) {
//        Pageable pageable = PageRequest.of(page, linesPerPage, Sort.by(direction.equalsIgnoreCase("asc") ? Sort.Direction.ASC : Sort.Direction.DESC, orderBy));
        return this.clienteSpringRepository.findAll();

    }
}
