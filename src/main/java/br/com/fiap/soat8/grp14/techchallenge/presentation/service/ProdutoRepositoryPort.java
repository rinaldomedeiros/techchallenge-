package br.com.fiap.soat8.grp14.techchallenge.presentation.service;

import br.com.fiap.soat8.grp14.techchallenge.core.entities.enums.CategoriaProduto;
import br.com.fiap.soat8.grp14.techchallenge.core.entities.Produto;

import java.util.List;

public interface ProdutoRepositoryPort {

    List<Produto> buscarTodos();

    Produto buscarPorId(Long id);

    List<Produto> buscarPorCategoria(CategoriaProduto categoriaProduto);

    Produto salvarProduto(Produto produto);

    Produto atualizarProduto(Long id, Produto produto);

    void deletarProduto(Long id);


}
