package br.com.fiap.soat8.grp14.techchallenge.core.usecases;

import br.com.fiap.soat8.grp14.techchallenge.app.dto.produto.ProdutoDTO;
import br.com.fiap.soat8.grp14.techchallenge.presentation.service.ProdutoRepositoryPort;
import br.com.fiap.soat8.grp14.techchallenge.core.entities.enums.CategoriaProduto;
import br.com.fiap.soat8.grp14.techchallenge.core.entities.Produto;

import java.util.List;
import java.util.stream.Collectors;

public class ProdutoServiceImpl {

    private final ProdutoRepositoryPort produtoRepositoryPort;

    public ProdutoServiceImpl(ProdutoRepositoryPort produtoRepositoryPort) {
        this.produtoRepositoryPort = produtoRepositoryPort;
    }


    public List<ProdutoDTO> buscarProdutos() {
        List<Produto> produtos = this.produtoRepositoryPort.buscarTodos();
        List<ProdutoDTO> produtoDTOS = produtos.stream().map(Produto::toProdutoDTO).collect(Collectors.toList());
        return produtoDTOS;
    }


    public ProdutoDTO buscarPorId(Long id) {
        Produto produto = this.produtoRepositoryPort.buscarPorId(id);
        return produto.toProdutoDTO();
    }

    public List<ProdutoDTO> buscarPorCategoria(CategoriaProduto categoriaProduto) {
        List<Produto> produtosPorCategoria = this.produtoRepositoryPort.buscarPorCategoria(categoriaProduto);
        return produtosPorCategoria.stream().map(Produto::toProdutoDTO).collect(Collectors.toList());
    }

    public ProdutoDTO salvarProduto(ProdutoDTO produtoDTO) {
        Produto produto = new Produto(produtoDTO);
        Produto produtoSalvo = produtoRepositoryPort.salvarProduto(produto);
        return produtoSalvo.toProdutoDTO();
    }

    public ProdutoDTO atualizarProduto(Long id, ProdutoDTO produtoDTO) {
        Produto produto = new Produto(produtoDTO);
        Produto produtoAtualizado = produtoRepositoryPort.atualizarProduto(id, produto);
        return produtoAtualizado.toProdutoDTO();
    }

    public void deletarProduto(Long id) {
        produtoRepositoryPort.deletarProduto(id);

    }
}


