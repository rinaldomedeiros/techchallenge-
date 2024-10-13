package br.com.fiap.soat8.grp14.techchallenge.core.usecases.produto;

import java.util.Optional;

import br.com.fiap.soat8.grp14.techchallenge.app.exceptions.DataIntegrityException;
import br.com.fiap.soat8.grp14.techchallenge.core.entities.Produto;
import br.com.fiap.soat8.grp14.techchallenge.core.interfaces.AbstractUseCase;
import br.com.fiap.soat8.grp14.techchallenge.data.models.ProdutoEntity;
import br.com.fiap.soat8.grp14.techchallenge.data.repositories.ProdutoRepository;

public class BuscarProdutoIdUseCase extends AbstractUseCase<Long, Produto> {

    private static final String ID_NAO_ENCONTRADO = "Produto não encontrado";

    private final ProdutoRepository repository;

    public BuscarProdutoIdUseCase(ProdutoRepository repository) {
        this.repository = repository;
    }

    @Override
    public Produto execute(Long id) {
        Optional<ProdutoEntity> produto = repository.findById(id);

        if (produto.isEmpty()) {
            throw new DataIntegrityException(ID_NAO_ENCONTRADO);
        }

        return getModelMapper().map(produto.get(), Produto.class);

    }

}
