package br.com.fiap.soat8.grp14.techchallenge.adapters.in.web;

import br.com.fiap.soat8.grp14.techchallenge.adapters.dto.ProdutoDTO;
import br.com.fiap.soat8.grp14.techchallenge.application.ports.in.ProdutoService;
import lombok.Getter;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/produtos")
public class ProdutoController {

    private final ProdutoService produtoService;

    public ProdutoController(ProdutoService produtoService) {
        this.produtoService = produtoService;
    }

    @PostMapping
    void salvarProdutos(@RequestBody ProdutoDTO produtoDTO) {
        produtoService.salvarProduto(produtoDTO);
    }

    @GetMapping
    List<ProdutoDTO> getProdutos() {
        return produtoService.buscarProdutos();
    }

}
