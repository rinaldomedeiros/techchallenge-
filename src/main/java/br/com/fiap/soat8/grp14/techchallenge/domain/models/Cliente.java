package br.com.fiap.soat8.grp14.techchallenge.domain.models;

import br.com.fiap.soat8.grp14.techchallenge.adapters.dto.ClienteDTO;

public class Cliente {

    private Long id;
    private String email;
    private String nome;
    private String senha;

    public Cliente() {
    }

    public Cliente(Long id, String email, String nome, String senha) {
        this.id = id;
        this.email = email;
        this.nome = nome;
        this.senha = senha;
    }

    public Cliente(ClienteDTO clienteDTO) {
        this.id = clienteDTO.getId();
        this.email = clienteDTO.getEmail();
        this.nome = clienteDTO.getNome();
        this.senha = clienteDTO.getSenha();
    }

    public ClienteDTO toClienteDTO() {
        return new ClienteDTO(this.id, this.email, this.nome, this.senha);
    }

    public Long getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public String getNome() {
        return nome;
    }

    public String getSenha() {
        return senha;
    }
}
