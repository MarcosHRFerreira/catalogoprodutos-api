package br.com.fiap.tc.catalogoprodutos_api.catalogoprodutos_api.domain.gateway;

import br.com.fiap.tc.catalogoprodutos_api.catalogoprodutos_api.domain.entity.Produto;

public interface CadastrarProdutoInterface {

    Produto cadastraProduto(Produto produto);

}
