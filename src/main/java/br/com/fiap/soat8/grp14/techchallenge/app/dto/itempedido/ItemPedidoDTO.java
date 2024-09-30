package br.com.fiap.soat8.grp14.techchallenge.app.dto.itempedido;

import br.com.fiap.soat8.grp14.techchallenge.app.dto.pedido.PedidoDTO;
import br.com.fiap.soat8.grp14.techchallenge.app.dto.produto.ProdutoDTO;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ItemPedidoDTO {

	@JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private Long id;
    private Integer quantidade;
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private Double valorItem;

    @JsonIgnore
    private PedidoDTO pedido;
    private ProdutoDTO produto;

}