package br.com.fiap.soat8.grp14.techchallenge.domain.entities;

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
@ToString
@Table(name = "cliente")
@Entity
public class Cliente extends BaseEntity {

    @Serial
    private static final long serialVersionUID = 6898207819633242925L;

    @Size(max = 255)
    @NotNull
    @Column(name = "email", nullable = false)
    private String email;

    @Size(max = 255)
    @NotNull
    @Column(name = "nome", nullable = false)
    private String nome;

    @Size(max = 14)
    @NotNull
    @Column(name = "cpf", nullable = false, length = 14)
    private String senha;

}
