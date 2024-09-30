package br.com.fiap.soat8.grp14.techchallenge.core.usecases;

import br.com.fiap.soat8.grp14.techchallenge.app.dto.produto.ProdutoDTO;
import br.com.fiap.soat8.grp14.techchallenge.application.ports.in.ProdutoServicePort;
import br.com.fiap.soat8.grp14.techchallenge.presentation.service.ProdutoRepositoryPort;
import br.com.fiap.soat8.grp14.techchallenge.core.entities.enums.CategoriaProduto;
import br.com.fiap.soat8.grp14.techchallenge.core.entities.Produto;

import java.util.List;
import java.util.stream.Collectors;

public class ProdutoServiceImpl implements ProdutoServicePort {

    private final ProdutoRepositoryPort produtoRepositoryPort;

    public ProdutoServiceImpl(ProdutoRepositoryPort produtoRepositoryPort) {
        this.produtoRepositoryPort = produtoRepositoryPort;
    }

    @Override
    public List<ProdutoDTO> buscarProdutos() {
        List<Produto> produtos = this.produtoRepositoryPort.buscarTodos();
        List<ProdutoDTO> produtoDTOS = produtos.stream().map(Produto::toProdutoDTO).collect(Collectors.toList());
        return produtoDTOS;
    }

    @Override
    public ProdutoDTO buscarPorId(Long id) {
        Produto produto = this.produtoRepositoryPort.buscarPorId(id);
        return produto.toProdutoDTO();
    }

    @Override
    public List<ProdutoDTO> buscarPorCategoria(CategoriaProduto categoriaProduto) {
        List<Produto> produtosPorCategoria = this.produtoRepositoryPort.buscarPorCategoria(categoriaProduto);
        return produtosPorCategoria.stream().map(Produto::toProdutoDTO).collect(Collectors.toList());
    }

    @Override
    public ProdutoDTO salvarProduto(ProdutoDTO produtoDTO) {
        Produto produto = new Produto(produtoDTO);
        Produto produtoSalvo = produtoRepositoryPort.salvarProduto(produto);
        return produtoSalvo.toProdutoDTO();
    }

    @Override
    public ProdutoDTO atualizarProduto(Long id, ProdutoDTO produtoDTO) {
        Produto produto = new Produto(produtoDTO);
        Produto produtoAtualizado = produtoRepositoryPort.atualizarProduto(id, produto);
        return produtoAtualizado.toProdutoDTO();
    }

    @Override
    public void deletarProduto(Long id) {
        produtoRepositoryPort.deletarProduto(id);

    }
}


