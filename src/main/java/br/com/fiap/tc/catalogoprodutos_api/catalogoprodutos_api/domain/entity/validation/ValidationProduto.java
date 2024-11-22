package br.com.fiap.tc.catalogoprodutos_api.catalogoprodutos_api.domain.entity.validation;

import br.com.fiap.tc.catalogoprodutos_api.catalogoprodutos_api.domain.entity.Produto;

public class ValidationProduto {

    private Produto produto;

    public ValidationProduto(Produto produto) {
        this.produto = produto;
    }
    public void validar() throws IllegalArgumentException {
        validarDescricao();
        validarPreco();
        validarQuantidade();
    }
    private void validarDescricao() {
        if(produto.getDescricao()==null || produto.getDescricao().trim().isEmpty() ){
            throw new IllegalArgumentException("A descrição do produto não pode ser vazio");
        }
        if(produto.getDescricao().length()<=3 || produto.getDescricao().length()>200){
            throw  new IllegalArgumentException("A descrição do produto deve ter no mínimo 3 caracteres e no máximo 200.");
        }
    }
    private void validarPreco() {
        if (produto.getPreco() == null ) {
            throw new IllegalArgumentException("O preço não pode ser vazio.");
        }
        if (produto.getPreco() < 0) {
            throw new IllegalArgumentException("O preço do produto não pode ser negativo.");
        }
        if (produto.getPreco() == 0) {
            throw new IllegalArgumentException("O preço do produto não pode ser zerado.");
        }
        if (!produto.getPreco().toString().matches("\\d+(\\.\\d+)?")) {
            throw new IllegalArgumentException("O preço deve conter apenas números e um ponto decimal.");
        }
    }
    private void validarQuantidade() {
        if (produto.getQuantidade() == null ) {
            throw new IllegalArgumentException("A quantidade do produto não pode ser vazio.");
        }
        if (produto.getQuantidade() < 0) {
            throw new IllegalArgumentException("A quantidade do produto não pode ser negativo.");
        }
        if (produto.getQuantidade() == 0) {
            throw new IllegalArgumentException("A quantidade do produto não pode ser zerada.");
        }
    }
}
