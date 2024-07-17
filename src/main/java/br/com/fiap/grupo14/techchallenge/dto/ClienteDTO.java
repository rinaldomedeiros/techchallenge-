package br.com.fiap.grupo14.techchallenge.dto;

import br.com.fiap.grupo14.techchallenge.entities.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.io.Serial;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ClienteDTO {

    private Long id;
    private String email;
    private String nome;
    private String senha;

}
