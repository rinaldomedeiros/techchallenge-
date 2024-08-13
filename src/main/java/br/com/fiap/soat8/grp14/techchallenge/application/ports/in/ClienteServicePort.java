package br.com.fiap.soat8.grp14.techchallenge.application.ports.in;

import java.util.List;

import br.com.fiap.soat8.grp14.techchallenge.adapters.dto.ClienteDTO;
import br.com.fiap.soat8.grp14.techchallenge.adapters.dto.ProdutoDTO;
import jakarta.validation.Valid;


public interface ClienteServicePort {

    List<ClienteDTO> listarTodos();

    ClienteDTO buscarCliente(String cpf);

    ClienteDTO buscarCliente(Long id);

    ClienteDTO salvarCliente(@Valid ClienteDTO clienteDTO);

    void excluirCliente(Long id);

    ClienteDTO atualizarCliente(Long id, ClienteDTO clienteDTO);


}
