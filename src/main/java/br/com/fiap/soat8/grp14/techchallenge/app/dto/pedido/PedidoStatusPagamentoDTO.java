package br.com.fiap.soat8.grp14.techchallenge.app.dto.pedido;

import br.com.fiap.soat8.grp14.techchallenge.core.entities.enums.StatusPagamento;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PedidoStatusPagamentoDTO {

    @NotNull
    private Long pedidoId;

    @NotNull
    private StatusPagamento statusPagamento;

}
