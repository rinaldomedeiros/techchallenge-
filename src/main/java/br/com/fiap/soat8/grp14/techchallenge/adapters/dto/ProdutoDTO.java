package br.com.fiap.soat8.grp14.techchallenge.adapters.dto;

import br.com.fiap.soat8.grp14.techchallenge.domain.enums.CategoriaProduto;


public class ProdutoDTO {


    private String nome;
    private String descricao;
    private Double valor;
    private CategoriaProduto categoriaProduto;


    public ProdutoDTO(String nome, String descricao, Double valor, CategoriaProduto categoriaProduto) {
        this.nome = nome;
        this.descricao = descricao;
        this.valor = valor;
        this.categoriaProduto = categoriaProduto;
    }


    public String getNome() {
        return nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public Double getValor() {
        return valor;
    }

    public CategoriaProduto getCategoriaProduto() {
        return categoriaProduto;
    }
}
