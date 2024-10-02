package br.com.fiap.soat8.grp14.techchallenge.presentation.controllers;

import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.core.annotation.Order;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/produtos")
@Order(2)
@Tag(name = "Produto", description = "API REST para cadastro e controle de pedidos")
public class ProdutoController {

//    private final ProdutoServicePort produtoServicePort;
//
//    public ProdutoController(ProdutoServicePort produtoServicePort) {
//        this.produtoServicePort = produtoServicePort;
//    }
//
//    @Operation(summary = "Este endpoint é responsável por cadastrar produtos.")
//    @PostMapping
//    public ResponseEntity<ProdutoDTO> salvarProdutos(@Valid @RequestBody ProdutoDTO produtoDTO) {
//        ProdutoDTO produtoSalvo = produtoServicePort.salvarProduto(produtoDTO);
//        return ResponseEntity.status(HttpStatus.CREATED).body(produtoSalvo);
//    }
//
//    @Operation(summary = "Este endpoint é responsável por recuperar todos os produtos.")
//    @GetMapping
//    public ResponseEntity<List<ProdutoDTO>> getProdutos() {
//        return ResponseEntity.ok(this.produtoServicePort.buscarProdutos());
//    }
//
//    @Operation(summary = "Este endpoint é responsável por recuperar produtos por id.")
//    @GetMapping(value = "/{id}")
//    public ResponseEntity<ProdutoDTO> getProdutoPorId(@PathVariable Long id) {
//
//        ProdutoDTO produtoBuscado = produtoServicePort.buscarPorId(id);
//        return ResponseEntity.ok(produtoBuscado);
//    }
//
//    @Operation(summary = "Este endpoint é responsável por recuperar produtos por categoria.")
//    @GetMapping(value = "/categoria/{categoriaProduto}")
//    public ResponseEntity<List<ProdutoDTO>> getProdutosPorCategoria(@PathVariable CategoriaProduto categoriaProduto) {
//        return ResponseEntity.ok(this.produtoServicePort.buscarPorCategoria(categoriaProduto));
//    }
//
//    @Operation(summary = "Este endpoint é responsável por atualizar produtos.")
//    @PutMapping(value = "/{id}")
//    public ResponseEntity<ProdutoDTO> atualizarProdutos(@PathVariable Long id, @Valid @RequestBody ProdutoDTO produtoDTO) {
//        ProdutoDTO produtoAtualizado = produtoServicePort.atualizarProduto(id, produtoDTO);
//        return ResponseEntity.ok(produtoAtualizado);
//    }
//
//    @Operation(summary = "Este endpoint é responsável por deletar produtos.")
//    @DeleteMapping(value = "/{id}")
//    public ResponseEntity<Void> deletaProdutos(@PathVariable Long id) {
//        produtoServicePort.deletarProduto(id);
//        return ResponseEntity.noContent().build();
//    }
}