package br.com.fiap.soat8.grp14.techchallenge.adapters.dto;

import java.util.List;

import br.com.fiap.soat8.grp14.techchallenge.domain.enums.StatusPedido;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class PedidoDTO {

    private Long id;
    private String numero;
    private Double valorTotal;
    private StatusPedido statusPedido;
    private ClienteDTO cliente;
    private List<ItemPedidoDTO> itens;

}
