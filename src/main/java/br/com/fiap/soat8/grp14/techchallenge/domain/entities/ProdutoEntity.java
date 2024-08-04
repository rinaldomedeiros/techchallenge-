package br.com.fiap.soat8.grp14.techchallenge.domain.entities;

import br.com.fiap.soat8.grp14.techchallenge.domain.Produto;
import br.com.fiap.soat8.grp14.techchallenge.domain.enums.CategoriaProduto;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.io.Serial;

@Builder
@Table(name = "produto")
@Entity
public class ProdutoEntity extends BaseEntity {

    @Serial
    private static final long serialVersionUID = -664752348563504951L;

    @Size(max = 255)
    @NotNull
    @Column(name = "nome", nullable = false)
    private String nome;

    @Size(max = 255)
    @NotNull
    @Column(name = "descricao", nullable = false)
    private String descricao;

    @NotNull
    @Column(name = "valor", nullable = false)
    private Double valor;

    @NotNull
    @Column(name = "categoria", nullable = false)
    private CategoriaProduto categoriaProduto;

    public ProdutoEntity(Produto produto) {
        this.nome = produto.getNome();
        this.descricao = produto.getDescricao();
        this.valor = produto.getValor();
        this.categoriaProduto = produto.getCategoriaProduto();
    }

//    public void atualizar(Produto produto) {
//        this.nome = produto.getNome();
//        this.descricao = produto.getDescricao();
//        this.valor = produto.getValor();
//        this.categoriaProduto = produto.getCategoriaProduto();
//    }

    public Produto toProduto() {
        return new Produto(this.nome, this.descricao, this.valor, this.categoriaProduto);

    }

}
