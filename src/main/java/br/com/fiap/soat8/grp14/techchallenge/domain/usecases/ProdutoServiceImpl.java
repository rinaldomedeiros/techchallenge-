package br.com.fiap.soat8.grp14.techchallenge.domain.usecases;

import br.com.fiap.soat8.grp14.techchallenge.adapters.dto.ProdutoDTO;
import br.com.fiap.soat8.grp14.techchallenge.application.ports.in.ProdutoService;
import br.com.fiap.soat8.grp14.techchallenge.application.ports.out.ProdutoRepositoryPort;
import br.com.fiap.soat8.grp14.techchallenge.domain.Produto;

import java.util.List;
import java.util.stream.Collectors;

public class ProdutoServiceImpl implements ProdutoService {

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
    public void salvarProduto(ProdutoDTO produtoDTO) {
        Produto produto = new Produto(produtoDTO);
        this.produtoRepositoryPort.salvarProduto(produto);
    }
}


