package br.com.fiap.grupo14.techchallenge2.application.ports.out;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.fiap.grupo14.techchallenge2.domain.entities.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {
}
