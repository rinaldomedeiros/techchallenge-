package br.com.fiap.soat8.grp14.techchallenge.adapter.out.persistence;

import br.com.fiap.soat8.grp14.techchallenge.domain.entities.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteSpringRepository extends JpaRepository<Cliente, Long> {
}
