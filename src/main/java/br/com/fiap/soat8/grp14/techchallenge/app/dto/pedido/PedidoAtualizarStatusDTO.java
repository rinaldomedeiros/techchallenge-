package br.com.fiap.soat8.grp14.techchallenge.app.dto.pedido;

import br.com.fiap.soat8.grp14.techchallenge.core.entities.enums.StatusPedido;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PedidoAtualizarStatusDTO {
    @NotNull
    StatusPedido status;

    @NotNull
    Long pedidoId;
}
