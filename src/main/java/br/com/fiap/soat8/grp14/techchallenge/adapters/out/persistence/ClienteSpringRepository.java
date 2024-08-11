package br.com.fiap.soat8.grp14.techchallenge.adapters.out.persistence;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.fiap.soat8.grp14.techchallenge.adapters.out.persistence.entities.ClienteEntity;

@Repository
public interface ClienteSpringRepository extends JpaRepository<ClienteEntity, Long> {
	public Optional<ClienteEntity> findByCpf(String cpf);
}
