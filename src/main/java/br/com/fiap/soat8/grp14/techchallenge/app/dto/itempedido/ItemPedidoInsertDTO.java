package br.com.fiap.soat8.grp14.techchallenge.app.dto.itempedido;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ItemPedidoInsertDTO {

    private Integer quantidade;

    private Double valorItem;

    private Long produtoId;

}
