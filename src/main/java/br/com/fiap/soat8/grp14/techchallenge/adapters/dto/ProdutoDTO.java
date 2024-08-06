package br.com.fiap.soat8.grp14.techchallenge.adapters.dto;

import br.com.fiap.soat8.grp14.techchallenge.domain.enums.CategoriaProduto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ProdutoDTO {

    private Long id;
    private String nome;
    private String descricao;
    private Double valor;
    private CategoriaProduto categoriaProduto;


}
