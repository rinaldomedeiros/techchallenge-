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

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PedidoDTO {

    private Long id;

    @Schema(accessMode = Schema.AccessMode.READ_ONLY)
    private Integer numero;

    @Schema(accessMode = Schema.AccessMode.READ_ONLY)
    private LocalDateTime dataPedido;

    @Schema(accessMode = Schema.AccessMode.READ_ONLY)
    private Double valorTotal;

    @Schema(accessMode = Schema.AccessMode.READ_ONLY)
    private StatusPedido statusPedido;

    @Schema(accessMode = Schema.AccessMode.READ_ONLY)
    private ClienteDTO cliente;

    private List<ItemPedidoDTO> itens;

}
