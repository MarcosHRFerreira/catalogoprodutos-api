package br.com.fiap.tc.catalogoprodutos_api.catalogoprodutos_api.domain.output;

public record ProdutoResponse(
        Long produtoId,
        String descricao,
        Double preco,
        Integer quantidade
) {
}
