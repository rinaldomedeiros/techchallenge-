package br.com.fiap.soat8.grp14.techchallenge.adapters.dto;

import br.com.fiap.soat8.grp14.techchallenge.domain.enums.StatusPedido;
import io.swagger.v3.oas.annotations.Hidden;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.media.SchemaProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PedidoDTO {

	@JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private Long id;

    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private Integer numero;

    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private LocalDateTime dataPedido;

    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private Double valorTotal;

    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private StatusPedido statusPedido;

    @Schema(accessMode = Schema.AccessMode.READ_ONLY)
    private ClienteDTO cliente;
    
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private Long clienteId;

    private List<ItemPedidoDTO> itens;

}
