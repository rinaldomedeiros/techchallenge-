package br.com.fiap.soat8.grp14.techchallenge.presentation.controllers;

import java.util.List;

import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.fiap.soat8.grp14.techchallenge.app.dto.produto.ProdutoDTO;
import br.com.fiap.soat8.grp14.techchallenge.app.services.ProdutoService;
import br.com.fiap.soat8.grp14.techchallenge.core.entities.enums.CategoriaProduto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/api/produtos")
@Tag(name = "Produto", description = "API REST para cadastro e controle de produtos")
@Order(2)
@AllArgsConstructor
public class ProdutoController {

    private final ProdutoService produtoService;

    @Operation(summary = "Este endpoint é responsável por cadastrar produtos.")
    @PostMapping
    public ResponseEntity<ProdutoDTO> salvarProdutos(@Valid @RequestBody ProdutoDTO produtoDTO) {
        ProdutoDTO produtoSalvo = produtoService.salvarProduto(produtoDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(produtoSalvo);
    }

    @Operation(summary = "Este endpoint é responsável por recuperar todos os produtos.")
    @GetMapping
    public ResponseEntity<List<ProdutoDTO>> getProdutos() {
        return ResponseEntity.ok(this.produtoService.buscarProdutos());
    }

    @Operation(summary = "Este endpoint é responsável por recuperar produtos por id.")
    @GetMapping(value = "/{id}")
    public ResponseEntity<ProdutoDTO> getProdutoPorId(@PathVariable Long id) {
        ProdutoDTO produtoBuscado = produtoService.buscarPorId(id);
        return ResponseEntity.ok(produtoBuscado);
    }

    @Operation(summary = "Este endpoint é responsável por recuperar produtos por categoria.")
    @GetMapping(value = "/categoria/{categoriaProduto}")
    public ResponseEntity<List<ProdutoDTO>> getProdutosPorCategoria(@PathVariable CategoriaProduto categoriaProduto) {
        return ResponseEntity.ok(this.produtoService.buscarPorCategoria(categoriaProduto));
    }

    @Operation(summary = "Este endpoint é responsável por atualizar produtos.")
    @PutMapping(value = "/{id}")
    public ResponseEntity<ProdutoDTO> atualizarProdutos(@PathVariable Long id, @Valid @RequestBody ProdutoDTO produtoDTO) {
        ProdutoDTO produtoAtualizado = produtoService.atualizarProduto(id, produtoDTO);
        return ResponseEntity.ok(produtoAtualizado);
    }

    @Operation(summary = "Este endpoint é responsável por deletar produtos.")
    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> deletaProdutos(@PathVariable Long id) {
        produtoService.deletarProduto(id);
        return ResponseEntity.noContent().build();
    }
}