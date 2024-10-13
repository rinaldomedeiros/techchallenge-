package br.com.fiap.soat8.grp14.techchallenge.app.dto.produto;

import br.com.fiap.soat8.grp14.techchallenge.core.entities.enums.CategoriaProduto;
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
public class ProdutoInsertDTO {

    @NotBlank(message = "O campo nome é obrigatório")
    @Size(min = 2, max = 255, message = "O campo nome deve ter entre {min} e {max} caracteres.")
    private String nome;

    @NotBlank(message = "O campo descricao é obrigatório")
    @Size(min = 2, max = 255, message = "O campo descricao deve ter entre {min} e {max} caracteres.")
    private String descricao;

    @NotNull(message = "O campo valor é obrigatório")
    @Min(0)
    private Double valor;

    @NotNull(message = "O campo categoriaProduto é obrigatório")
    private CategoriaProduto categoriaProduto;

}
