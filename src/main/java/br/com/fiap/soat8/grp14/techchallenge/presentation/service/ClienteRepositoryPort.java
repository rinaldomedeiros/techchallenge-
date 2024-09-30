package br.com.fiap.soat8.grp14.techchallenge.presentation.service;

import java.util.List;

import br.com.fiap.soat8.grp14.techchallenge.core.entities.Cliente;

public interface ClienteRepositoryPort {
    List<Cliente> listarTodos();

    Cliente buscarCliente(String cpf);
    
    Cliente buscarCliente(Long id);
	
    Cliente salvarCliente(Cliente cliente);

	void excluirCliente(Cliente cliente);

	Cliente atualizarCliente(Long id, Cliente cliente);
	
}
