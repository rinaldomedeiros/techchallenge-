package br.com.fiap.soat8.grp14.techchallenge.adapters.in.web;

import br.com.fiap.soat8.grp14.techchallenge.adapters.dto.ProdutoDTO;
import br.com.fiap.soat8.grp14.techchallenge.application.ports.in.ProdutoServicePort;
import br.com.fiap.soat8.grp14.techchallenge.domain.enums.CategoriaProduto;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;

import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/produtos")
@Order(2)
@Tag(name = "Produto", description = "API REST para cadastro e controle de pedidos")
public class ProdutoController {

    private final ProdutoServicePort produtoServicePort;

    public ProdutoController(ProdutoServicePort produtoServicePort) {
        this.produtoServicePort = produtoServicePort;
    }

    @PostMapping
    public ResponseEntity<ProdutoDTO> salvarProdutos(@Valid @RequestBody ProdutoDTO produtoDTO) {
        ProdutoDTO produtoSalvo = produtoServicePort.salvarProduto(produtoDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(produtoSalvo);
    }

    @GetMapping
    public ResponseEntity<List<ProdutoDTO>> getProdutos() {
        return ResponseEntity.ok(this.produtoServicePort.buscarProdutos());
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<ProdutoDTO> getProdutoPorId(@PathVariable Long id) {

        ProdutoDTO produtoBuscado = produtoServicePort.buscarPorId(id);
        return ResponseEntity.ok(produtoBuscado);
    }

    @GetMapping(value = "/categoria/{categoriaProduto}")
    public ResponseEntity<List<ProdutoDTO>> getProdutosPorCategoria(@PathVariable CategoriaProduto categoriaProduto) {
        return ResponseEntity.ok(this.produtoServicePort.buscarPorCategoria(categoriaProduto));
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<ProdutoDTO> atualizarProdutos(@PathVariable Long id, @Valid @RequestBody ProdutoDTO produtoDTO) {
        ProdutoDTO produtoAtualizado = produtoServicePort.atualizarProduto(id, produtoDTO);
        return ResponseEntity.ok(produtoAtualizado);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> deletaProdutos(@PathVariable Long id) {

        produtoServicePort.deletarProduto(id);
        return ResponseEntity.noContent().build();
    }
}