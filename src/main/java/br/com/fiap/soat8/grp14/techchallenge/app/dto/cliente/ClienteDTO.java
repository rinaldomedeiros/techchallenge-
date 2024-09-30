package br.com.fiap.soat8.grp14.techchallenge.app.dto.cliente;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ClienteDTO {

    private Long id;
    
    @NotBlank(message = "O campo email é obrigatório")
    @Size(min = 2, max = 255, message = "O campo email deve ter entre {min} e {max} caracteres.")
    private String email;
    
    @NotBlank(message = "O campo nome é obrigatório")
    @Size(min = 2, max = 255, message = "O campo nome deve ter entre {min} e {max} caracteres.")
    private String nome;
    
    @NotBlank(message = "O campo cpf é obrigatório")
    @Size(min = 14, max = 14, message = "O campo cpf deve estar no formato XXX.XXX.XXX-XX.")
    private String cpf;

}
