package br.com.fiap.soat8.grp14.techchallenge.core.entities;

import br.com.fiap.soat8.grp14.techchallenge.app.dto.itempedido.ItemPedidoDTO;
import br.com.fiap.soat8.grp14.techchallenge.app.dto.pedido.PedidoDTO;
import br.com.fiap.soat8.grp14.techchallenge.core.entities.enums.StatusPedido;
import lombok.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@EqualsAndHashCode
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Pedido {

    private Long id;
    private Integer numero;
    private LocalDateTime dataPedido;
    private Double valorTotal;
    private StatusPedido statusPedido;
    private Cliente cliente;
    private List<ItemPedido> itens = new ArrayList<>();

}