package br.com.fiap.soat8.grp14.techchallenge.adapters.out.persistence.impl;

import br.com.fiap.soat8.grp14.techchallenge.adapters.out.persistence.ProdutoSpringRepository;
import br.com.fiap.soat8.grp14.techchallenge.application.ports.out.ProdutoRepositoryPort;
import br.com.fiap.soat8.grp14.techchallenge.domain.enums.CategoriaProduto;
import br.com.fiap.soat8.grp14.techchallenge.domain.models.Produto;
import br.com.fiap.soat8.grp14.techchallenge.adapters.out.persistence.entities.ProdutoEntity;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
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
    public List<Produto> buscarPorCategoria(CategoriaProduto categoriaProduto) {
        List<ProdutoEntity> produtoEntitiesCategoria = this.produtoSpringRepository.findByCategoriaProduto(categoriaProduto);
        return produtoEntitiesCategoria.stream().map(ProdutoEntity::toProduto).collect(Collectors.toList());
    }

    @Override
    public void salvarProduto(Produto produto) {
        ProdutoEntity produtoEntity = new ProdutoEntity(produto);
        this.produtoSpringRepository.save(produtoEntity);
    }

    @Override
    public Produto buscarPorId(Long id) {
        Optional<ProdutoEntity> produtoEntity = this.produtoSpringRepository.findById(id);
        if (produtoEntity.isPresent())
            return produtoEntity.get().toProduto();
        return null;

        // throw new RuntimeException("Produto não localizado na base de Dados");
    }

    @Override
    public void deletarProduto(Long id) {
        produtoSpringRepository.findById(id).ifPresent(produtoSpringRepository::delete);

    }

    @Override
    public void atualizarProduto(Long id, Produto produto) {

        ProdutoEntity produtoExistente = produtoSpringRepository.
                findById(id).orElseThrow(() ->
                        new RuntimeException("Produto não encontrado"));
        produtoExistente.setNome(produto.getNome());
        produtoExistente.setDescricao(produto.getDescricao());
        produtoExistente.setValor(produto.getValor());
        produtoExistente.setCategoriaProduto(produto.getCategoriaProduto());

        ProdutoEntity produtoAtualizado = produtoSpringRepository.save(produtoExistente);

    }
}



