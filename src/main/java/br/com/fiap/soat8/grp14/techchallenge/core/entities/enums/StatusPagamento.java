package br.com.fiap.soat8.grp14.techchallenge.core.entities.enums;

public enum StatusPagamento {
    APROVADO("Aprovado", "Pagamento aprovado."),
    NAO_APROVADO("Aprovado", "Pagamento aprovado.");

    private final String nome;
    private final String descricao;

    StatusPagamento(String nome, String descricao) {
        this.nome = nome;
        this.descricao = descricao;
    }

}