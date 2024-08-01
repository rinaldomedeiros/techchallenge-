package br.com.fiap.soat8.grp14.techchallenge.domain.enums;

public enum CategoriaProduto {
    LANCHE("Lanche"),
    ACOMPANHAMENTO("Acompanhamento"),
    BEBIDA("Bebida"),
    SOBREMESA("Sobremesa");

    private final String nome;

    CategoriaProduto(String nome) {
        this.nome = nome;
    }

}