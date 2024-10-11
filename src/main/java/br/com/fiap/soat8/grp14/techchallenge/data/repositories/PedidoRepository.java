package br.com.fiap.soat8.grp14.techchallenge.data.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import br.com.fiap.soat8.grp14.techchallenge.data.models.PedidoEntity;

@Repository
public interface PedidoRepository extends BaseRepository<PedidoEntity> {
    Optional<PedidoEntity> findTopByOrderByNumeroDesc();

    List<PedidoEntity> findByCliente_Id(long idCliente);
    
    PedidoEntity findByNumero(Integer nrPedido);

}
