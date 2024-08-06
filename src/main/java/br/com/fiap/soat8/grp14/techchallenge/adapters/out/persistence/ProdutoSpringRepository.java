package br.com.fiap.soat8.grp14.techchallenge.adapters.out.persistence;

import br.com.fiap.soat8.grp14.techchallenge.adapters.out.persistence.entities.ProdutoEntity;
import br.com.fiap.soat8.grp14.techchallenge.domain.enums.CategoriaProduto;
import br.com.fiap.soat8.grp14.techchallenge.domain.models.Produto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProdutoSpringRepository extends JpaRepository<ProdutoEntity, Long> {
    List<ProdutoEntity> findByCategoriaProduto(CategoriaProduto categoriaProduto);

}
