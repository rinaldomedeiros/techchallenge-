package br.com.fiap.soat8.grp14.techchallenge.core.entities;

import br.com.fiap.soat8.grp14.techchallenge.app.dto.cliente.ClienteDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Cliente {

    private Long id;
    private String email;
    private String nome;
    private String cpf;

    public Cliente(ClienteDTO clienteDTO) {
		if(clienteDTO != null) {
			this.id    = clienteDTO.getId();
			this.email = clienteDTO.getEmail();
			this.nome  = clienteDTO.getNome();
			this.cpf   = clienteDTO.getCpf();
		}
    }

    public ClienteDTO toClienteDTO() {
        return new ClienteDTO(this.id, this.email, this.nome, this.cpf);
    }

}
