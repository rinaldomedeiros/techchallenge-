package br.com.fiap.soat8.grp14.techchallenge.app.services;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import br.com.fiap.soat8.grp14.techchallenge.app.dto.produto.ProdutoDTO;
import br.com.fiap.soat8.grp14.techchallenge.app.dto.produto.ProdutoInsertDTO;
import br.com.fiap.soat8.grp14.techchallenge.core.entities.enums.CategoriaProduto;
import br.com.fiap.soat8.grp14.techchallenge.core.usecases.produto.AtualizarProdutoUseCase;
import br.com.fiap.soat8.grp14.techchallenge.core.usecases.produto.BuscarProdutoCategoriaUseCase;
import br.com.fiap.soat8.grp14.techchallenge.core.usecases.produto.BuscarProdutoIdUseCase;
import br.com.fiap.soat8.grp14.techchallenge.core.usecases.produto.CriarProdutoUseCase;
import br.com.fiap.soat8.grp14.techchallenge.core.usecases.produto.ExcluirProdutoUseCase;
import br.com.fiap.soat8.grp14.techchallenge.core.usecases.produto.ListarProdutosUseCase;
import br.com.fiap.soat8.grp14.techchallenge.data.models.ProdutoEntity;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ProdutoService {

    private final CriarProdutoUseCase criarProdutoUseCase;
    private final BuscarProdutoCategoriaUseCase buscarProdutoCategoriaUseCase;
    private final ListarProdutosUseCase listarProdutoUseCase;
    private final BuscarProdutoIdUseCase buscarProdutoIdUseCase;
    private final ExcluirProdutoUseCase excluirProdutoUseCase;
    private final AtualizarProdutoUseCase atualizarProdutoUseCase;

    private final ModelMapper mapper;

    public List<ProdutoDTO> buscarProdutos() {
        return this.listarProdutoUseCase.execute(true).stream().map(produto -> mapper.map(produto, ProdutoDTO.class)).toList();
    }

    public ProdutoDTO buscarPorId(Long id) {
        return mapper.map(this.buscarProdutoIdUseCase.execute(id), ProdutoDTO.class);
    }

    public List<ProdutoDTO> buscarPorCategoria(CategoriaProduto categoriaProduto) {
        return this.buscarProdutoCategoriaUseCase.execute(categoriaProduto).stream().map(produto -> mapper.map(produto, ProdutoDTO.class)).toList();
    }

    public ProdutoDTO salvarProduto(ProdutoInsertDTO produtoInsertDTO) {
        return mapper.map(this.criarProdutoUseCase.execute(mapper.map(produtoInsertDTO, ProdutoEntity.class)), ProdutoDTO.class);
    }

    public ProdutoDTO atualizarProduto(Long id, ProdutoDTO produtoDTO) {
        return mapper.map(this.atualizarProdutoUseCase.execute(mapper.map(produtoDTO, ProdutoEntity.class)), ProdutoDTO.class);
    }

    public void deletarProduto(Long id) {
        excluirProdutoUseCase.execute(id);
    }
}
