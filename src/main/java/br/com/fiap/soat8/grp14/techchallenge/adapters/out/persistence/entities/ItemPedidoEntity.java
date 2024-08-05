package br.com.fiap.soat8.grp14.techchallenge.adapters.out.persistence.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.io.Serial;

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
}
