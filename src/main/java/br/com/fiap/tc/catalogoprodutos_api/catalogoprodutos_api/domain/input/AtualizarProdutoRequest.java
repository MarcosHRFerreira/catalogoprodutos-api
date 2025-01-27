package br.com.fiap.tc.catalogoprodutos_api.catalogoprodutos_api.domain.input;

public record AtualizarProdutoRequest(
        String descricao,
        Double preco,
        Integer quantidade
) {
}
