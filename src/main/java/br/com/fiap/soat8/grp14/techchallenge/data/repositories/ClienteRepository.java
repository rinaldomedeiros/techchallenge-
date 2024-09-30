package br.com.fiap.soat8.grp14.techchallenge.data.repositories;

import br.com.fiap.soat8.grp14.techchallenge.data.models.ClienteEntity;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ClienteRepository extends BaseRepository<ClienteEntity> {
	public Optional<ClienteEntity> findByCpf(String cpf);
}
