package br.com.fiap.soat8.grp14.techchallenge.adapters.out.persistence;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.fiap.soat8.grp14.techchallenge.adapters.out.persistence.entities.PedidoEntity;

@Repository
public interface PedidoSpringRepository extends JpaRepository<PedidoEntity, Long> {
    Optional<PedidoEntity> findTopByOrderByNumeroDesc();

	public List<PedidoEntity> findByClienteEntity_Id(long idCliente);

}
