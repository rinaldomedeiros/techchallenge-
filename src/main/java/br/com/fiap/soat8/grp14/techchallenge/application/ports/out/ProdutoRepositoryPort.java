package br.com.fiap.soat8.grp14.techchallenge.application.ports.out;

import br.com.fiap.soat8.grp14.techchallenge.domain.enums.CategoriaProduto;
import br.com.fiap.soat8.grp14.techchallenge.domain.models.Produto;

import java.util.List;

public interface ProdutoRepositoryPort {

    List<Produto> buscarTodos();

    Produto buscarPorId(Long id);

    List<Produto>buscarPorCategoria(CategoriaProduto categoriaProduto);

    void salvarProduto(Produto produto);



    void atualizarProduto (Long id, Produto produto);

   void deletarProduto(Long id);


}
