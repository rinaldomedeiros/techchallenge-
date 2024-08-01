package br.com.fiap.soat8.grp14.techchallenge.domain.enums;

public enum StatusPedido {
    RECEBIDO("Recebido", "Pedido foi recebido pela cozinha"),
    EM_PREPARACAO("Em preparação", "O preparo do pedido foi iniciado"),
    PRONTO("Pronto", "Indica que o preparo pedido foi concluído e está aguardando a retirada"),
    FINALIZADO("Finalizado", "O pedido foi retirado pelo cliente");

    private final String nome;
    private final String descricao;

    StatusPedido(String nome, String descricao) {
        this.nome = nome;
        this.descricao = descricao;
    }

}