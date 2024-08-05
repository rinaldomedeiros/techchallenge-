package br.com.fiap.soat8.grp14.techchallenge.application.ports.in;

import br.com.fiap.soat8.grp14.techchallenge.adapters.dto.ProdutoDTO;
import org.springframework.data.crossstore.ChangeSetPersister;

import java.util.List;

public interface ProdutoServicePort {

    List<ProdutoDTO> buscarProdutos();

    ProdutoDTO buscarPorId(Long id);

    void salvarProduto(ProdutoDTO produtoDTO);

    void atualizarProduto(Long id, ProdutoDTO produtoDTO) throws ChangeSetPersister.NotFoundException;

    void deletarProduto(Long id);


}
