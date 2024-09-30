package br.com.fiap.soat8.grp14.techchallenge.core.entities;

import br.com.fiap.soat8.grp14.techchallenge.app.dto.itempedido.ItemPedidoDTO;

public class ItemPedido {

    private Long id;
    private Integer quantidade;
    private Double valorItem;
    private Pedido pedido;
    private Produto produto;

    public ItemPedido() {
    }

    public ItemPedido(Long id, Integer quantidade, Double valorItem, Produto produto) {
        this.id = id;
        this.quantidade = quantidade;
        this.valorItem = valorItem;
        this.produto = produto;
    }

    public ItemPedido(ItemPedidoDTO itemPedidoDTO) {
        this.id = itemPedidoDTO.getId();
        this.quantidade = itemPedidoDTO.getQuantidade();
        this.valorItem = itemPedidoDTO.getValorItem();
        this.pedido = itemPedidoDTO.getPedido() != null ? new Pedido(itemPedidoDTO.getPedido()) : null;
        this.produto = itemPedidoDTO.getProduto() != null ? new Produto(itemPedidoDTO.getProduto()) : null;
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