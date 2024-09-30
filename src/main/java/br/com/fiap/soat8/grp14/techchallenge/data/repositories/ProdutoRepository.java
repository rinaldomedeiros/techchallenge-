package br.com.fiap.soat8.grp14.techchallenge.data.repositories;

import br.com.fiap.soat8.grp14.techchallenge.core.entities.enums.CategoriaProduto;
import br.com.fiap.soat8.grp14.techchallenge.data.models.ProdutoEntity;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProdutoRepository extends BaseRepository<ProdutoEntity> {
    List<ProdutoEntity> findByCategoriaProduto(CategoriaProduto categoriaProduto);
}
