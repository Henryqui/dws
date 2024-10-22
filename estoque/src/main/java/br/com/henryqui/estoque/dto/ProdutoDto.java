package br.com.henryqui.estoque.dto;

import java.math.BigDecimal;

public class ProdutoDto {
    private Long id;
    private String nomeproduto;
    private BigDecimal preco;
    private String categoria;

    public ProdutoDto(Long id, String nomeproduto, BigDecimal preco, String categoria) {
        this.id = id;
        this.nomeproduto = nomeproduto;
        this.preco = preco;
        this.categoria = categoria;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNomeproduto() {
        return nomeproduto;
    }

    public void setNomeproduto(String nomeproduto) {
        this.nomeproduto = nomeproduto;
    }

    public BigDecimal getPreco() {
        return preco;
    }

    public void setPreco(BigDecimal preco) {
        this.preco = preco;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }
}
