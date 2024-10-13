package br.com.fiap.soat8.grp14.techchallenge.core.usecases.produto;

import br.com.fiap.soat8.grp14.techchallenge.core.entities.Produto;
import br.com.fiap.soat8.grp14.techchallenge.core.interfaces.AbstractUseCase;
import br.com.fiap.soat8.grp14.techchallenge.data.models.ProdutoEntity;
import br.com.fiap.soat8.grp14.techchallenge.data.repositories.ProdutoRepository;

public class CriarProdutoUseCase extends AbstractUseCase<ProdutoEntity, Produto> {

    private final ProdutoRepository repository;

    public CriarProdutoUseCase(ProdutoRepository repository) {
        this.repository = repository;
    }

    @Override
    public Produto execute(ProdutoEntity produtoEntity) {
        return getModelMapper().map(repository.save(produtoEntity), Produto.class);
    }

}
