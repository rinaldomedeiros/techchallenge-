package br.com.fiap.soat8.grp14.techchallenge.adapters.out.persistence;

import br.com.fiap.soat8.grp14.techchallenge.adapters.out.persistence.entities.ProdutoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProdutoSpringRepository extends JpaRepository<ProdutoEntity, Long> {

}
