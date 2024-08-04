package br.com.fiap.soat8.grp14.techchallenge.domain;

import br.com.fiap.soat8.grp14.techchallenge.adapters.dto.ProdutoDTO;
import br.com.fiap.soat8.grp14.techchallenge.domain.enums.CategoriaProduto;

public class Produto {

    private String nome;
    private String descricao;
    private Double valor;
    private CategoriaProduto categoriaProduto;

    public Produto() {
    }

    public Produto(String nome, String descricao, Double valor, CategoriaProduto categoriaProduto) {

        this.nome = nome;
        this.descricao = descricao;
        this.valor = valor;
        this.categoriaProduto = categoriaProduto;
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
        this.nome = produtoDTO.getNome();
        this.descricao = produtoDTO.getDescricao();
        this.valor = produtoDTO.getValor();
        this.categoriaProduto = produtoDTO.getCategoriaProduto();

    }

//    public void atualizarProduto(String nome, String descricao, double valor) {
//
//        this.nome = nome;
//        this.descricao = descricao;
//        this.valor = valor;
//    }


    public ProdutoDTO toProdutoDTO() {

        return new ProdutoDTO(this.nome, this.descricao, this.valor, this.categoriaProduto);

    }


}


