package br.com.fiap.soat8.grp14.techchallenge.app.dto.pedido;

import br.com.fiap.soat8.grp14.techchallenge.app.dto.itempedido.ItemPedidoDTO;
import br.com.fiap.soat8.grp14.techchallenge.app.dto.cliente.ClienteDTO;
import br.com.fiap.soat8.grp14.techchallenge.app.dto.itempedido.ItemPedidoInsertDTO;
import br.com.fiap.soat8.grp14.techchallenge.core.entities.enums.StatusPedido;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class PedidoInsertDTO {

    @NotNull(message = "O id do cliente não pode ser nulo")
    private Long clienteId;

    @NotNull(message = "A lista de itens não pode ser nula")
    @Size(min = 1, message = "O pedido deve conter ao menos um item")
    @Valid
    private List<ItemPedidoInsertDTO> itens;


}
