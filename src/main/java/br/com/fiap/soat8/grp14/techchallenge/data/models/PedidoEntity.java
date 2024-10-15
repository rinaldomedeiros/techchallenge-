package br.com.fiap.soat8.grp14.techchallenge.data.models;

import java.io.Serial;
import java.time.LocalDateTime;
import java.util.List;

import br.com.fiap.soat8.grp14.techchallenge.core.entities.enums.StatusPagamento;
import br.com.fiap.soat8.grp14.techchallenge.core.entities.enums.StatusPedido;
import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
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
    private ClienteEntity cliente;

    @OneToMany(mappedBy = "pedido", cascade = CascadeType.ALL, orphanRemoval = true)
    @ToString.Exclude
    private List<ItemPedidoEntity> itens;

    @Column(name = "status_pagamento")
    private StatusPagamento statusPagamento;

    @PrePersist
    protected void onCreate() {
        this.dataPedido = LocalDateTime.now();
    }

}
