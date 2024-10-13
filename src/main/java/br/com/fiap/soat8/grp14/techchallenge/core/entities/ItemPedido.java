package br.com.fiap.soat8.grp14.techchallenge.core.entities;

import br.com.fiap.soat8.grp14.techchallenge.app.dto.itempedido.ItemPedidoDTO;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class ItemPedido {

    private Long id;
    private Integer quantidade;
    private Double valorItem;
    private Pedido pedido;
    private Produto produto;

}