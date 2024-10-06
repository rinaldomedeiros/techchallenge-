package br.com.fiap.soat8.grp14.techchallenge.app.dto.pedido;

import br.com.fiap.soat8.grp14.techchallenge.app.dto.itempedido.ItemPedidoDTO;
import br.com.fiap.soat8.grp14.techchallenge.app.dto.cliente.ClienteDTO;
import br.com.fiap.soat8.grp14.techchallenge.core.entities.enums.StatusPedido;
import jakarta.validation.Valid;
import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class PedidoInsertDTO {

    private Long id;

    @NotNull(message = "o campo numero é obirgatório")
    @Min(0)
    private Integer numero;

    @NotNull(message = "a data do pedido não pode ser nula")
    @FutureOrPresent(message = "a data do pedido deve estar no presente ou no futuro do momento atual")
    private LocalDateTime dataPedido;

    @NotNull(message = "o campo valor é obrigatório")
    @Min(0)
    private Double valorTotal;

    @NotNull(message = "O status do pedido não pode ser nulo")
    private StatusPedido statusPedido;

    @NotNull(message = "O cliente não pode ser nulo")
    @Valid
    private ClienteDTO cliente;

    private Long clienteId;

    @NotNull(message = "A lista de itens não pode ser nula")
    @Size(min = 1, message = "O pedido deve conter ao menos um item")
    @Valid
    private List<ItemPedidoDTO> itens;


}
