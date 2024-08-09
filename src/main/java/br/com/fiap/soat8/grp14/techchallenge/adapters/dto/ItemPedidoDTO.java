package br.com.fiap.soat8.grp14.techchallenge.adapters.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ItemPedidoDTO {

    private Long id;
    private Integer quantidade;
    private Double valorItem;
    private PedidoDTO pedido;
    private ProdutoDTO produto;

}
