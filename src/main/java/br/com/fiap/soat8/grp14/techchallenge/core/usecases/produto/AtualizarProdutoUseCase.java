package br.com.fiap.soat8.grp14.techchallenge.core.usecases.produto;

import br.com.fiap.soat8.grp14.techchallenge.app.exceptions.EntityNotFoundException;
import br.com.fiap.soat8.grp14.techchallenge.core.entities.Produto;
import br.com.fiap.soat8.grp14.techchallenge.core.interfaces.AbstractUseCase;
import br.com.fiap.soat8.grp14.techchallenge.data.models.ProdutoEntity;
import br.com.fiap.soat8.grp14.techchallenge.data.repositories.ProdutoRepository;

public class AtualizarProdutoUseCase extends AbstractUseCase<ProdutoEntity, Produto> {

    private static final String ID_NAO_ENCONTRADO = "Produto não encontrado";

    private final ProdutoRepository repository;

    public AtualizarProdutoUseCase(ProdutoRepository repository) {
        this.repository = repository;
    }

    @Override
    public Produto execute(ProdutoEntity produtoEntity) {
        repository.findById(
                produtoEntity.getId()).orElseThrow(() -> new EntityNotFoundException(ID_NAO_ENCONTRADO));
        return getModelMapper().map(this.repository.save(produtoEntity), Produto.class);
    }

}
