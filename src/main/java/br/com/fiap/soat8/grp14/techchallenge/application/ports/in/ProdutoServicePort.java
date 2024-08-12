package br.com.fiap.soat8.grp14.techchallenge.application.ports.in;

import br.com.fiap.soat8.grp14.techchallenge.adapters.dto.ProdutoDTO;
import br.com.fiap.soat8.grp14.techchallenge.domain.enums.CategoriaProduto;
import br.com.fiap.soat8.grp14.techchallenge.domain.exceptions.EntityNotFoundException;

import java.util.List;

public interface ProdutoServicePort {

    List<ProdutoDTO> buscarProdutos();

    ProdutoDTO buscarPorId(Long id);

    List<ProdutoDTO> buscarPorCategoria(CategoriaProduto categoriaProduto);

    ProdutoDTO salvarProduto(ProdutoDTO produtoDTO);

    ProdutoDTO atualizarProduto(Long id, ProdutoDTO produtoDTO);

    void deletarProduto(Long id);


}
