package br.com.fiap.soat8.grp14.techchallenge.adapters.out.persistence.entities;

import br.com.fiap.soat8.grp14.techchallenge.domain.enums.StatusPedido;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.io.Serial;

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

    @Size(max = 10)
    @NotNull
    @Column(name = "numero", nullable = false)
    private String numero;

    @NotNull
    @Column(name = "status", nullable = false)
    private StatusPedido statusPedido;

    @NotNull
    @Column(name = "valor_total", nullable = false)
    private Double valorTotal;

    @ManyToOne
    @JoinColumn(name = "cliente_id")
    private ClienteEntity clienteEntity;
}
