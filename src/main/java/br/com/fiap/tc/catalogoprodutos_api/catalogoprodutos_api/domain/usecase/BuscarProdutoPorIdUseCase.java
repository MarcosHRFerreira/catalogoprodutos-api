package br.com.fiap.tc.catalogoprodutos_api.catalogoprodutos_api.domain.usecase;

import br.com.fiap.tc.catalogoprodutos_api.catalogoprodutos_api.domain.entity.Produto;
import br.com.fiap.tc.catalogoprodutos_api.catalogoprodutos_api.domain.exception.ProdutoNotFoundException;
import br.com.fiap.tc.catalogoprodutos_api.catalogoprodutos_api.domain.gateway.BuscarProdutoPorIdInterface;


public class BuscarProdutoPorIdUseCase {

    private final BuscarProdutoPorIdInterface buscarProdutoPorIdInterface;

    public BuscarProdutoPorIdUseCase(BuscarProdutoPorIdInterface buscarProdutoPorIdInterface) {
        this.buscarProdutoPorIdInterface = buscarProdutoPorIdInterface;
    }

    public Produto buscarProdutoPorId(Long id){

        Produto produto=buscarProdutoPorIdInterface.buscarProdutoPorId(id);

        if(produto==null){
            throw new ProdutoNotFoundException("Produto de id: " + id + " não encontrado.");
        }
        return produto;
    }

}
