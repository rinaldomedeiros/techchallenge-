package br.com.fiap.soat8.grp14.techchallenge.app.dto.pedido;

import java.time.LocalDateTime;
import java.util.List;

import br.com.fiap.soat8.grp14.techchallenge.app.dto.cliente.ClienteDTO;
import br.com.fiap.soat8.grp14.techchallenge.app.dto.itempedido.ItemPedidoDTO;
import br.com.fiap.soat8.grp14.techchallenge.core.entities.enums.StatusPedido;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PedidoDTO {

    private Long id;

    private Integer numero;

    @NotNull(message = "a data do pedido não pode ser nula")
    private LocalDateTime dataPedido;

    private Double valorTotal;

    @NotNull(message = "O status do pedido não pode ser nulo")
    private StatusPedido statusPedido;

    private ClienteDTO cliente;

    private Long clienteId;

    @NotNull(message = "A lista de itens não pode ser nula")
    @Size(min = 1, message = "O pedido deve conter ao menos um item")
    @Valid
    private List<ItemPedidoDTO> itens;

}
