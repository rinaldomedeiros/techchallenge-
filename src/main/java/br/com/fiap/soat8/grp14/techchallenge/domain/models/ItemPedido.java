package br.com.fiap.soat8.grp14.techchallenge.domain.models;

import br.com.fiap.soat8.grp14.techchallenge.adapters.dto.ItemPedidoDTO;

public class ItemPedido {

    private Long id;
    private Integer quantidade;
    private Double valorItem;
    private Pedido pedido;
    private Produto produto;

    public ItemPedido() {
    }

    public ItemPedido(Long id, Integer quantidade, Double valorItem, Pedido pedido, Produto produto) {
        this.id = id;
        this.quantidade = quantidade;
        this.valorItem = valorItem;
        this.pedido = pedido;
        this.produto = produto;
    }

    public ItemPedido(ItemPedidoDTO itemPedidoDTO) {
        this.id = itemPedidoDTO.getId();
        this.quantidade = itemPedidoDTO.getQuantidade();
        this.valorItem = itemPedidoDTO.getValorItem();
        this.pedido = new Pedido(itemPedidoDTO.getPedido());
        this.produto = new Produto(itemPedidoDTO.getProduto());
    }

    public ItemPedidoDTO toItemPedidoDTO() {
        return new ItemPedidoDTO(
                this.id,
                this.quantidade,
                this.valorItem,
                this.pedido != null ? this.pedido.toPedidoDTO() : null,
                this.produto != null ? this.produto.toProdutoDTO() : null);
    }

    public Long getId() {
        return id;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public Double getValorItem() {
        return valorItem;
    }

    public Pedido getPedido() {
        return pedido;
    }

    public Produto getProduto() {
        return produto;
    }
}