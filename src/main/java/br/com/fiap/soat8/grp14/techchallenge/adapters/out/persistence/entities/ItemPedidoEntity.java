package br.com.fiap.soat8.grp14.techchallenge.adapters.out.persistence.entities;

import java.io.Serial;

import br.com.fiap.soat8.grp14.techchallenge.domain.models.ItemPedido;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Table(name = "item_pedido")
@Entity
public class ItemPedidoEntity extends BaseEntity {

    @Serial
    private static final long serialVersionUID = 8949519988726287601L;

    @NotNull
    @Column(name = "quantidade", nullable = false)
    private Integer quantidade;

    @NotNull
    @Column(name = "valor", nullable = false)
    private Double valorItem;

    @ManyToOne
    @JoinColumn(name = "pedido_id")
    private PedidoEntity pedidoEntity;

    @ManyToOne
    @JoinColumn(name = "produto_id")
    private ProdutoEntity produtoEntity;

    public ItemPedidoEntity(ItemPedido itemPedido) {
        this.id = itemPedido.getId();
        this.quantidade = itemPedido.getQuantidade();
        this.valorItem = itemPedido.getValorItem();
        this.pedidoEntity = new PedidoEntity(itemPedido.getPedido());
        this.produtoEntity = new ProdutoEntity(itemPedido.getProduto());
    }

    public ItemPedido toItemPedido() {
        return new ItemPedido(
                this.id,
                this.quantidade,
                this.valorItem,
                this.pedidoEntity != null ? this.pedidoEntity.toPedido() : null,
                this.produtoEntity != null ? this.produtoEntity.toProduto() : null);
    }
}
