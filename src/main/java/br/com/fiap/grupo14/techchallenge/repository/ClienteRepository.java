package br.com.fiap.grupo14.techchallenge.repository;

import br.com.fiap.grupo14.techchallenge.entities.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {
}
