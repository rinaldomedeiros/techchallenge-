package br.com.fiap.soat8.grp14.techchallenge.core.entities;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import br.com.fiap.soat8.grp14.techchallenge.core.entities.enums.StatusPedido;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

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