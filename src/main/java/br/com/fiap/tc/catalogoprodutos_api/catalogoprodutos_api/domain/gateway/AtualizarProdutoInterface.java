package br.com.fiap.tc.catalogoprodutos_api.catalogoprodutos_api.domain.gateway;

import br.com.fiap.tc.catalogoprodutos_api.catalogoprodutos_api.domain.entity.Produto;

public interface AtualizarProdutoInterface {

    Produto atualizarProduto(Long id, Produto produto);

}
