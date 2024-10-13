package br.com.fiap.soat8.grp14.techchallenge.core.entities;

import br.com.fiap.soat8.grp14.techchallenge.app.dto.produto.ProdutoDTO;
import br.com.fiap.soat8.grp14.techchallenge.core.entities.enums.CategoriaProduto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Produto {

    private Long id;
    private String nome;
    private String descricao;
    private Double valor;
    private CategoriaProduto categoriaProduto;

    public Produto(ProdutoDTO produtoDTO) {
        this.id = produtoDTO.getId();
        this.nome = produtoDTO.getNome();
        this.descricao = produtoDTO.getDescricao();
        this.valor = produtoDTO.getValor();
        this.categoriaProduto = produtoDTO.getCategoriaProduto();
    }

    public ProdutoDTO toProdutoDTO() {
        return new ProdutoDTO(this.id, this.nome, this.descricao, this.valor, this.categoriaProduto);
    }

}
