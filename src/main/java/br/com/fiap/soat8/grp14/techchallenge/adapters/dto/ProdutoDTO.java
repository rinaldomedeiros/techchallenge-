package br.com.fiap.soat8.grp14.techchallenge.adapters.dto;

import br.com.fiap.soat8.grp14.techchallenge.domain.enums.CategoriaProduto;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProdutoDTO {

    private Long id;

    @NotBlank(message = "O campo nome é obrigatório")
    @Size(min = 2, max = 255, message = "O campo {property} deve ter entre {min} e {max} caracteres.")
    private String nome;

    @NotBlank(message = "O campo descricao é obrigatório")
    @Size(min = 2, max = 255, message = "O campo {property} deve ter entre {min} e {max} caracteres.")
    private String descricao;

    @NotNull
    @Min(0)
    private Double valor;

    @NotNull(message = "O campo categoriaProduto é obrigatório")
    private CategoriaProduto categoriaProduto;


}
