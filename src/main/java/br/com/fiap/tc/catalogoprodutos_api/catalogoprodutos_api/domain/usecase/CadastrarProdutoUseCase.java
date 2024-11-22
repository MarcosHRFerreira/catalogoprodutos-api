package br.com.fiap.tc.catalogoprodutos_api.catalogoprodutos_api.domain.usecase;

import br.com.fiap.tc.catalogoprodutos_api.catalogoprodutos_api.domain.entity.Produto;
import br.com.fiap.tc.catalogoprodutos_api.catalogoprodutos_api.domain.gateway.CadastrarProdutoInterface;

public class CadastrarProdutoUseCase {

    private final CadastrarProdutoInterface cadastrarProdutoInterface;


    public CadastrarProdutoUseCase(CadastrarProdutoInterface cadastrarProdutoInterface) {
        this.cadastrarProdutoInterface = cadastrarProdutoInterface;
    }

    public Produto cadastarProduto(Produto produto){
        return cadastrarProdutoInterface.cadastraProduto(produto);
    }

}
