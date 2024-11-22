package br.com.fiap.tc.catalogoprodutos_api.catalogoprodutos_api.domain.input;

public record CadastrarProdutoRequest(
         Long produtoId,
         String descricao,
         Double preco,
         Integer quantidade
) {
}
