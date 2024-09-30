package br.com.fiap.soat8.grp14.techchallenge.app.dto.cliente;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class BuscarClienteCpfDTO {

    @NotBlank(message = "O campo cpf é obrigatório")
    @Size(min = 14, max = 14, message = "O campo cpf deve estar no formato XXX.XXX.XXX-XX.")
    private String cpf;

}
