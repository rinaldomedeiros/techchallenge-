package br.com.fiap.soat8.grp14.techchallenge.application.ports.in;

import br.com.fiap.soat8.grp14.techchallenge.adapters.dto.ProdutoDTO;
import org.springframework.data.crossstore.ChangeSetPersister;

import java.util.List;

public interface ProdutoService {

    List<ProdutoDTO> buscarProdutos();

    void salvarProduto(ProdutoDTO produtoDTO);

//    void atualizarProduto(String nome, String descricao, double valor) throws ChangeSetPersister.NotFoundException;
//
//    void deletarProduto();


}
