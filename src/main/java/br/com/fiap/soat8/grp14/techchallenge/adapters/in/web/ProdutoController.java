package br.com.fiap.soat8.grp14.techchallenge.adapters.in.web;

import br.com.fiap.soat8.grp14.techchallenge.adapters.dto.ProdutoDTO;
import br.com.fiap.soat8.grp14.techchallenge.application.ports.in.ProdutoServicePort;
import br.com.fiap.soat8.grp14.techchallenge.domain.enums.CategoriaProduto;
import br.com.fiap.soat8.grp14.techchallenge.domain.exceptions.EntityNotFoundException;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/api/produtos")
public class ProdutoController {

    private final ProdutoServicePort produtoServicePort;

    public ProdutoController(ProdutoServicePort produtoServicePort) {
        this.produtoServicePort = produtoServicePort;
    }

    @PostMapping
    public ResponseEntity<Void> salvarProdutos(@Valid @RequestBody ProdutoDTO produtoDTO) {
        produtoServicePort.salvarProduto(produtoDTO);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping
    public ResponseEntity<List<ProdutoDTO>> getProdutos() {
        return ResponseEntity.ok(this.produtoServicePort.buscarProdutos());
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<ProdutoDTO> getProdutoPorId(@PathVariable Long id) throws EntityNotFoundException {

        ProdutoDTO produtoBuscado = produtoServicePort.buscarPorId(id);
        return ResponseEntity.ok(produtoBuscado);
    }

    @GetMapping(value = "/categoria/{categoriaProduto}")
    public ResponseEntity<List<ProdutoDTO>> getProdutosPorCategoria(@PathVariable CategoriaProduto categoriaProduto) {
        return ResponseEntity.ok(this.produtoServicePort.buscarPorCategoria(categoriaProduto));
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity atualizarProdutos(@PathVariable Long id, @Valid @RequestBody ProdutoDTO produtoDTO) {

        produtoServicePort.atualizarProduto(id, produtoDTO);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> deletaProdutos(@PathVariable Long id) {

        produtoServicePort.deletarProduto(id);
        return ResponseEntity.noContent().build();
    }
}