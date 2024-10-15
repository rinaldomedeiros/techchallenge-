package br.com.fiap.soat8.grp14.techchallenge.core.entities.enums;

public enum StatusPagamento {
    EM_APROVACAO("Em aprovação", "Agurando a aprovação do pagamento"),
    APROVADO("Aprovado", "Pagamento aprovado."),
    REJEITADO("Rejeitado", "A forma de pagamento selecionanda foi rejeitada"),
    CANCELADO("Cancelado", "O pagamento foi cancelado pelo cliente");

    private final String nome;
    private final String descricao;

    StatusPagamento(String nome, String descricao) {
        this.nome = nome;
        this.descricao = descricao;
    }

}