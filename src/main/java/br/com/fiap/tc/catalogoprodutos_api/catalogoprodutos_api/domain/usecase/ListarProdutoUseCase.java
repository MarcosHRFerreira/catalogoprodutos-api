package br.com.fiap.tc.catalogoprodutos_api.catalogoprodutos_api.domain.usecase;

import br.com.fiap.tc.catalogoprodutos_api.catalogoprodutos_api.domain.entity.Produto;
import br.com.fiap.tc.catalogoprodutos_api.catalogoprodutos_api.domain.gateway.ListarProdutoInterface;
import br.com.fiap.tc.catalogoprodutos_api.catalogoprodutos_api.domain.output.ProdutoDeletadoResponse;

import java.util.List;

public class ListarProdutoUseCase {

    private final ListarProdutoInterface listarProdutoInterface;


    public ListarProdutoUseCase(ListarProdutoInterface listarProdutoInterface) {
        this.listarProdutoInterface = listarProdutoInterface;
    }

    public List<Produto> listarProdutos(){
        return listarProdutoInterface.listarProdutos();
    }


}
