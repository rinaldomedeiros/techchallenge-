package br.com.fiap.soat8.grp14.techchallenge.application.ports.out;

import java.util.List;

import br.com.fiap.soat8.grp14.techchallenge.domain.models.Cliente;

public interface ClienteRepositoryPort {
    List<Cliente> listarTodos();

    Cliente buscarCliente(String cpf);
    
    Cliente buscarCliente(Long id);
	
    Cliente salvarCliente(Cliente cliente);

	void excluirCliente(Cliente cliente);

	void atualizarCliente(Long id, Cliente cliente);
	
}
