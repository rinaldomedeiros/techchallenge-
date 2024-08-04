package br.com.fiap.soat8.grp14.techchallenge.application.ports.out;

import br.com.fiap.soat8.grp14.techchallenge.domain.Produto;

import java.util.List;

public interface ProdutoRepositoryPort {

    List<Produto> buscarTodos();

//    Produto buscarPorId(Long id);

    void salvarProduto(Produto produto);
//
//    void deletarProduto(Long id);


}
