package br.com.fiap.soat8.grp14.techchallenge.data.repositories;

import br.com.fiap.soat8.grp14.techchallenge.data.models.PedidoEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PedidoRepository extends BaseRepository<PedidoEntity> {
    Optional<PedidoEntity> findTopByOrderByNumeroDesc();

    List<PedidoEntity> findByClienteEntity_Id(long idCliente);

}
