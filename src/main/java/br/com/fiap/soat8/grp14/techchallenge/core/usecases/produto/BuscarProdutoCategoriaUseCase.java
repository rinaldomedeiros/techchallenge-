package br.com.fiap.soat8.grp14.techchallenge.core.usecases.produto;

import java.util.List;

import br.com.fiap.soat8.grp14.techchallenge.core.entities.Produto;
import br.com.fiap.soat8.grp14.techchallenge.core.entities.enums.CategoriaProduto;
import br.com.fiap.soat8.grp14.techchallenge.core.interfaces.AbstractUseCase;
import br.com.fiap.soat8.grp14.techchallenge.data.models.ProdutoEntity;
import br.com.fiap.soat8.grp14.techchallenge.data.repositories.ProdutoRepository;

public class BuscarProdutoCategoriaUseCase extends AbstractUseCase<CategoriaProduto, List<Produto>> {

    private final ProdutoRepository repository;

    public BuscarProdutoCategoriaUseCase(ProdutoRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Produto> execute(CategoriaProduto categoria) {
        List<ProdutoEntity> produtosList = repository.findByCategoriaProduto(categoria);
        return produtosList.stream().map(produto -> getModelMapper().map(produto, Produto.class)).toList();
    }

}
