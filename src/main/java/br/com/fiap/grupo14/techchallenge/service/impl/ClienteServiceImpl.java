package br.com.fiap.grupo14.techchallenge.service.impl;

import br.com.fiap.grupo14.techchallenge.dto.ClienteDTO;
import br.com.fiap.grupo14.techchallenge.entities.Cliente;
import br.com.fiap.grupo14.techchallenge.repository.ClienteRepository;
import br.com.fiap.grupo14.techchallenge.service.ClienteService;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import lombok.Getter;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ClienteServiceImpl implements ClienteService {

    @PersistenceContext
    private EntityManager manager;

    @Getter
    @Autowired
    private ModelMapper modelMapper;

    private ClienteRepository repository;

    public ClienteServiceImpl(ClienteRepository repository) {
        this.repository = repository;
    }

    @Transactional(propagation= Propagation.REQUIRED, readOnly=true, noRollbackFor=Exception.class)
    public Page<ClienteDTO> findAll(Integer page, Integer linesPerPage, String orderBy, String direction)  {
        Pageable pageable = PageRequest.of(page, linesPerPage, Sort.by(direction.equalsIgnoreCase("asc") ? Sort.Direction.ASC : Sort.Direction.DESC, orderBy));

        Page<Cliente> resultado = repository.findAll(pageable);
//        if (resultado.isEmpty()) {
//            throw new ObjetoNaoEncontradoException(String.format(MSG_NENHUM_OBJETO_ENCONTRADO, this.getEntityClass().getName()));
//        }
        return resultado.map(objectEntity -> modelMapper.map(objectEntity, ClienteDTO.class));
    }

}
