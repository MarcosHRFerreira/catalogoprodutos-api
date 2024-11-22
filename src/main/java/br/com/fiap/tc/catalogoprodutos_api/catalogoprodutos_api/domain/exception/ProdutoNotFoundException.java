package br.com.fiap.tc.catalogoprodutos_api.catalogoprodutos_api.domain.exception;

public class ProdutoNotFoundException extends RuntimeException {
    public ProdutoNotFoundException(String message) {
        super(message);
    }
}