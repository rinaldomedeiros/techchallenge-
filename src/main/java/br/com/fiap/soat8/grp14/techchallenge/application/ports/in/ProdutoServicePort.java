package br.com.fiap.soat8.grp14.techchallenge.application.ports.in;

import br.com.fiap.soat8.grp14.techchallenge.adapters.dto.ProdutoDTO;
import br.com.fiap.soat8.grp14.techchallenge.domain.enums.CategoriaProduto;
import br.com.fiap.soat8.grp14.techchallenge.domain.exceptions.EntityNotFoundException;
import org.springframework.data.crossstore.ChangeSetPersister;

import java.util.List;

public interface ProdutoServicePort {

    List<ProdutoDTO> buscarProdutos();

    ProdutoDTO buscarPorId (Long id) throws EntityNotFoundException;

    List<ProdutoDTO> buscarPorCategoria(CategoriaProduto categoriaProduto);

    void salvarProduto(ProdutoDTO produtoDTO);

    void atualizarProduto(Long id, ProdutoDTO produtoDTO) throws ChangeSetPersister.NotFoundException;

    void deletarProduto(Long id);



}
