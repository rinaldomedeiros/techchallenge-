package br.com.fiap.soat8.grp14.techchallenge.adapters.out.persistence.impl;

import br.com.fiap.soat8.grp14.techchallenge.adapters.out.persistence.ProdutoSpringRepository;
import br.com.fiap.soat8.grp14.techchallenge.application.ports.out.ProdutoRepositoryPort;
import br.com.fiap.soat8.grp14.techchallenge.domain.Produto;
import br.com.fiap.soat8.grp14.techchallenge.domain.entities.ProdutoEntity;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class ProdutoRepositoryImpl implements ProdutoRepositoryPort {

    private final ProdutoSpringRepository produtoSpringRepository;

    public ProdutoRepositoryImpl(ProdutoSpringRepository produtoSpringRepository) {
        this.produtoSpringRepository = produtoSpringRepository;
    }

    @Override
    public List<Produto> buscarTodos() {
        List<ProdutoEntity> produtoEntities = this.produtoSpringRepository.findAll();
        return produtoEntities.stream().map(ProdutoEntity::toProduto).collect(Collectors.toList());
    }

    @Override
    public void salvarProduto(Produto produto) {
        ProdutoEntity produtoEntity = new ProdutoEntity(produto);
        this.produtoSpringRepository.save(produtoEntity);
    }


}
