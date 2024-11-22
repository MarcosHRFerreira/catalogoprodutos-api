package br.com.fiap.tc.catalogoprodutos_api.catalogoprodutos_api.domain.entity;

public class Produto {


    private Long produtoId;
    private String descricao;
    private Double preco;
    private Integer quantidade;

    public Produto(Long produtoId, String descricao, Double preco, Integer quantidade) {
        this.produtoId = produtoId;
        this.descricao = descricao;
        this.preco = preco;
        this.quantidade = quantidade;
    }

    public Produto() {
    }

    public Long getProdutoId() {
        return produtoId;
    }

    public void setProdutoId(Long produtoId) {
        this.produtoId = produtoId;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Double getPreco() {
        return preco;
    }

    public void setPreco(Double preco) {
        this.preco = preco;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }
}
