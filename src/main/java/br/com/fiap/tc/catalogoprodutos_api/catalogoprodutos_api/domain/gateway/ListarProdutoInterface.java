package br.com.fiap.tc.catalogoprodutos_api.catalogoprodutos_api.domain.gateway;

import br.com.fiap.tc.catalogoprodutos_api.catalogoprodutos_api.domain.entity.Produto;

import java.util.List;

public interface ListarProdutoInterface {
    List<Produto>listarProdutos();
}
