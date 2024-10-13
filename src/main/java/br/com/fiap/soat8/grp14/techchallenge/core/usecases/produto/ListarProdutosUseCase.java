package br.com.fiap.soat8.grp14.techchallenge.core.usecases.produto;

import java.util.List;

import br.com.fiap.soat8.grp14.techchallenge.core.entities.Produto;
import br.com.fiap.soat8.grp14.techchallenge.core.interfaces.AbstractUseCase;
import br.com.fiap.soat8.grp14.techchallenge.data.models.ProdutoEntity;
import br.com.fiap.soat8.grp14.techchallenge.data.repositories.ProdutoRepository;

public class ListarProdutosUseCase extends AbstractUseCase<Boolean, List<Produto>> {

    private final ProdutoRepository repository;

    public ListarProdutosUseCase(ProdutoRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Produto> execute(Boolean dummy) {
        List<ProdutoEntity> produtosList = repository.findAll();
        return produtosList.stream().map(produto -> getModelMapper().map(produto, Produto.class)).toList();
    }

}
