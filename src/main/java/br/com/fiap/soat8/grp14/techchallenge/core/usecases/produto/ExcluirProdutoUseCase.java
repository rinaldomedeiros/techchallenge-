package br.com.fiap.soat8.grp14.techchallenge.core.usecases.produto;

import br.com.fiap.soat8.grp14.techchallenge.core.entities.Produto;
import br.com.fiap.soat8.grp14.techchallenge.core.interfaces.AbstractUseCase;
import br.com.fiap.soat8.grp14.techchallenge.data.models.ProdutoEntity;
import br.com.fiap.soat8.grp14.techchallenge.data.repositories.ProdutoRepository;

public class ExcluirProdutoUseCase extends AbstractUseCase<Long, Boolean> {

    private final ProdutoRepository repository;
    private final BuscarProdutoIdUseCase buscarProdutoIdUseCase;

    public ExcluirProdutoUseCase(ProdutoRepository repository, BuscarProdutoIdUseCase buscarProdutoIdUseCase) {
        this.repository = repository;
        this.buscarProdutoIdUseCase = buscarProdutoIdUseCase;
    }

    @Override
    public Boolean execute(Long id) {
        Produto produto = buscarProdutoIdUseCase.execute(id);
        repository.delete(getModelMapper().map(produto, ProdutoEntity.class));
        return true;
    }

}
