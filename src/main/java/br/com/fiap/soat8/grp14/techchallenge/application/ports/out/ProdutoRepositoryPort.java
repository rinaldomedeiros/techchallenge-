package br.com.fiap.soat8.grp14.techchallenge.application.ports.out;

import br.com.fiap.soat8.grp14.techchallenge.domain.models.Produto;

import java.util.List;

public interface ProdutoRepositoryPort {

    List<Produto> buscarTodos();

    void salvarProduto(Produto produto);

    Produto buscarPorId(Long id);

    void atualizarProduto (Long id, Produto produto);

   void deletarProduto(Long id);


}
