package br.com.fiap.soat8.grp14.techchallenge.domain.models;

import br.com.fiap.soat8.grp14.techchallenge.adapters.dto.ProdutoDTO;
import br.com.fiap.soat8.grp14.techchallenge.domain.enums.CategoriaProduto;

public class Produto {

    private Long id;
    private String nome;
    private String descricao;
    private Double valor;
    private CategoriaProduto categoriaProduto;

    public Produto() {
    }

    public Produto(Long id, String nome, String descricao, Double valor, CategoriaProduto categoriaProduto) {

        this.id = id;
        this.nome = nome;
        this.descricao = descricao;
        this.valor = valor;
        this.categoriaProduto = categoriaProduto;
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public Double getValor() {
        return valor;
    }

    public CategoriaProduto getCategoriaProduto() {
        return categoriaProduto;
    }

    public Produto(ProdutoDTO produtoDTO) {
        this.id = produtoDTO.getId();
        this.nome = produtoDTO.getNome();
        this.descricao = produtoDTO.getDescricao();
        this.valor = produtoDTO.getValor();
        this.categoriaProduto = produtoDTO.getCategoriaProduto();

    }


    public ProdutoDTO toProdutoDTO() {

        return new ProdutoDTO(this.id, this.nome, this.descricao, this.valor, this.categoriaProduto);

    }


}


