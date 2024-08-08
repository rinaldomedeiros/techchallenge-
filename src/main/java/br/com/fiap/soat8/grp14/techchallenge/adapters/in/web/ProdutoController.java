package br.com.fiap.soat8.grp14.techchallenge.adapters.in.web;

import br.com.fiap.soat8.grp14.techchallenge.adapters.dto.ProdutoDTO;
import br.com.fiap.soat8.grp14.techchallenge.application.ports.in.ProdutoServicePort;
import br.com.fiap.soat8.grp14.techchallenge.domain.enums.CategoriaProduto;
import jakarta.validation.Valid;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/produtos")
public class ProdutoController {

    private final ProdutoServicePort produtoServicePort;

    public ProdutoController(ProdutoServicePort produtoServicePort) {
        this.produtoServicePort = produtoServicePort;
    }

    @PostMapping
    void salvarProdutos(@Valid @RequestBody ProdutoDTO produtoDTO) {
        produtoServicePort.salvarProduto(produtoDTO);
    }

    @GetMapping
    List<ProdutoDTO> getProdutos() {
        return produtoServicePort.buscarProdutos();
    }

    @GetMapping(value = "/{id}")
    ProdutoDTO getProdutoPorId(@PathVariable Long id) {
        return produtoServicePort.buscarPorId(id);
    }


    @GetMapping(value = "/categoria/{categoriaProduto}")
    List<ProdutoDTO> getProdutosPorCategoria(@PathVariable CategoriaProduto categoriaProduto) {
        return produtoServicePort.buscarPorCategoria(categoriaProduto);
    }

    @PutMapping(value = "/{id}")
    void atualizarProdutos(@PathVariable Long id, @Valid @RequestBody ProdutoDTO produtoDTO) throws ChangeSetPersister.NotFoundException {
        produtoServicePort.atualizarProduto(id, produtoDTO);
    }

    @DeleteMapping(value = "/{id}")
    void deletaProdutos(@PathVariable Long id) {
        produtoServicePort.deletarProduto(id);
    }

}
