package br.com.fiap.soat8.grp14.techchallenge.domain.usecases;

import br.com.fiap.soat8.grp14.techchallenge.adapters.dto.ProdutoDTO;
import br.com.fiap.soat8.grp14.techchallenge.application.ports.in.ProdutoServicePort;
import br.com.fiap.soat8.grp14.techchallenge.application.ports.out.ProdutoRepositoryPort;
import br.com.fiap.soat8.grp14.techchallenge.domain.Produto;
import org.springframework.data.crossstore.ChangeSetPersister;

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
        ProdutoDTO produtoBuscado = produto.toProdutoDTO();
        return produtoBuscado;

    }

    @Override
    public void salvarProduto(ProdutoDTO produtoDTO) {
        Produto produto = new Produto(produtoDTO);
        this.produtoRepositoryPort.salvarProduto(produto);
    }

    @Override
    public void atualizarProduto(Long id, ProdutoDTO produtoDTO) throws ChangeSetPersister.NotFoundException {
        Produto produto = new Produto(produtoDTO);
        this.produtoRepositoryPort.atualizarProduto(id, produto);

    }

    @Override
    public void deletarProduto(Long id) {
        produtoRepositoryPort.deletarProduto(id);

    }
}


