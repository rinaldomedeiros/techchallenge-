package br.com.fiap.soat8.grp14.techchallenge.adapters.out.persistence.entities;

import java.io.Serial;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import br.com.fiap.soat8.grp14.techchallenge.domain.enums.StatusPedido;
import br.com.fiap.soat8.grp14.techchallenge.domain.models.Pedido;
import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
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
@Table(name = "pedido")
@Entity
public class PedidoEntity extends BaseEntity {

    @Serial
    private static final long serialVersionUID = 1632367913305406090L;

    @Min(1)
    @Max(1000)
    @NotNull
    @Column(name = "numero", nullable = false)
    private Integer numero;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "data_pedido", nullable = false)
    private LocalDateTime dataPedido;

    @NotNull
    @Column(name = "status", nullable = false)
    private StatusPedido statusPedido;

    @NotNull
    @Column(name = "valor_total", nullable = false)
    private Double valorTotal;

    @ManyToOne
    @JoinColumn(name = "cliente_id")
    private ClienteEntity clienteEntity;

    @OneToMany(mappedBy = "pedidoEntity", cascade = CascadeType.ALL, orphanRemoval = true)
    @ToString.Exclude
    private List<ItemPedidoEntity> itens;

    @PrePersist
    protected void onCreate() {
        this.dataPedido = LocalDateTime.now();
    }

    public PedidoEntity(Pedido pedido) {
        if (pedido != null) {
            this.id = pedido.getId();
            this.numero = pedido.getNumero();
            this.dataPedido = pedido.getDataPedido();
            this.valorTotal = pedido.getValorTotal();
            this.statusPedido = pedido.getStatusPedido();
            this.clienteEntity = pedido.getCliente() != null ? new ClienteEntity(pedido.getCliente()) : null;
            this.itens = pedido.getItens().stream().map(ItemPedidoEntity::new).collect(Collectors.toList());
        }
    }

    public Pedido toPedido() {
        return new Pedido(
                this.id,
                this.numero,
                this.dataPedido,
                this.valorTotal,
                this.statusPedido,
                this.clienteEntity != null ? this.clienteEntity.toCliente() : null,
                this.itens.stream().map(ItemPedidoEntity::toItemPedido).collect(Collectors.toList())
        );
    }
}
