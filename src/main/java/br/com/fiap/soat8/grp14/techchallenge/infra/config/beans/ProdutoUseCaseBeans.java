package br.com.fiap.soat8.grp14.techchallenge.infra.config.beans;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import br.com.fiap.soat8.grp14.techchallenge.core.usecases.produto.AtualizarProdutoUseCase;
import br.com.fiap.soat8.grp14.techchallenge.core.usecases.produto.BuscarProdutoCategoriaUseCase;
import br.com.fiap.soat8.grp14.techchallenge.core.usecases.produto.BuscarProdutoIdUseCase;
import br.com.fiap.soat8.grp14.techchallenge.core.usecases.produto.CriarProdutoUseCase;
import br.com.fiap.soat8.grp14.techchallenge.core.usecases.produto.ExcluirProdutoUseCase;
import br.com.fiap.soat8.grp14.techchallenge.core.usecases.produto.ListarProdutosUseCase;
import br.com.fiap.soat8.grp14.techchallenge.data.repositories.ProdutoRepository;

@Configuration
public class ProdutoUseCaseBeans {

    @Bean
    public AtualizarProdutoUseCase atualizarProdutoUseCase(ProdutoRepository repository) {
        return new AtualizarProdutoUseCase(repository);
    }

    @Bean
    public BuscarProdutoCategoriaUseCase buscarProdutoCategoriaUseCase(ProdutoRepository repository) {
        return new BuscarProdutoCategoriaUseCase(repository);
    }

    @Bean
    public BuscarProdutoIdUseCase buscarProdutoIdUseCase(ProdutoRepository repository) {
        return new BuscarProdutoIdUseCase(repository);
    }

    @Bean
    public CriarProdutoUseCase criarProdutoUseCase(ProdutoRepository repository) {
        return new CriarProdutoUseCase(repository);
    }

    @Bean
    public ExcluirProdutoUseCase excluirProdutoUseCase(ProdutoRepository repository,
            BuscarProdutoIdUseCase buscarProdutoIdUseCase) {
        return new ExcluirProdutoUseCase(repository, buscarProdutoIdUseCase);
    }

    @Bean
    public ListarProdutosUseCase listarProdutosUseCase(ProdutoRepository repository) {
        return new ListarProdutosUseCase(repository);
    }

}
