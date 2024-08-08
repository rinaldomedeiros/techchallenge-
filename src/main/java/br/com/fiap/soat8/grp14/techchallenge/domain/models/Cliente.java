package br.com.fiap.soat8.grp14.techchallenge.domain.models;

import br.com.fiap.soat8.grp14.techchallenge.adapters.dto.ClienteDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class Cliente {

    private Long id;
    private String email;
    private String nome;
    private String cpf;

    public Cliente(ClienteDTO clienteDTO) {
        this.id = clienteDTO.getId();
        this.email = clienteDTO.getEmail();
        this.nome = clienteDTO.getNome();
        this.cpf = clienteDTO.getCpf();
    }

    public ClienteDTO toClienteDTO() {
        return new ClienteDTO(this.id, this.email, this.nome, this.cpf);
    }

}
