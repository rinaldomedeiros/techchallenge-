package br.com.fiap.soat8.grp14.techchallenge.domain.usecases;

import br.com.fiap.soat8.grp14.techchallenge.adapters.dto.ProdutoDTO;
import br.com.fiap.soat8.grp14.techchallenge.application.ports.in.ProdutoServicePort;
import br.com.fiap.soat8.grp14.techchallenge.application.ports.out.ProdutoRepositoryPort;
import br.com.fiap.soat8.grp14.techchallenge.domain.enums.CategoriaProduto;
import br.com.fiap.soat8.grp14.techchallenge.domain.models.Produto;

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
        List<ProdutoDTO> produtoDTOSCategoria = produtosPorCategoria.stream().map(Produto::toProdutoDTO).collect(Collectors.toList());
        return produtoDTOSCategoria;
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


