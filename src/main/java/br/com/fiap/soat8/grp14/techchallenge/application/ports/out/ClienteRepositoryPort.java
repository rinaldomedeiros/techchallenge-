package br.com.fiap.soat8.grp14.techchallenge.application.ports.out;

import java.util.List;
import java.util.Optional;

import br.com.fiap.soat8.grp14.techchallenge.domain.models.Cliente;

public interface ClienteRepositoryPort {
    List<Cliente> listarTodos();

    Optional<Cliente> buscarCliente(String cpf);
    
    Optional<Cliente> buscarCliente(Long id);
	
    Cliente salvarCliente(Cliente cliente);

	void excluirCliente(Cliente cliente);
	
}
