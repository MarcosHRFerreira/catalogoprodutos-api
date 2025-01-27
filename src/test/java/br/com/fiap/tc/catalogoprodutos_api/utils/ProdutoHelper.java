package br.com.fiap.tc.catalogoprodutos_api.utils;

import br.com.fiap.tc.catalogoprodutos_api.catalogoprodutos_api.domain.entity.Produto;
import br.com.fiap.tc.catalogoprodutos_api.catalogoprodutos_api.domain.input.AtualizarProdutoRequest;
import br.com.fiap.tc.catalogoprodutos_api.catalogoprodutos_api.domain.input.CadastrarProdutoRequest;
import br.com.fiap.tc.catalogoprodutos_api.catalogoprodutos_api.domain.output.ProdutoResponse;
import br.com.fiap.tc.catalogoprodutos_api.catalogoprodutos_api.infra.entity.ProdutoEntity;

public class ProdutoHelper {


    public static Produto gerarProdutoValido(){

         String descricao = "Sabonete";
         Double preco = 10.0;
         Integer quantidade= 1;

         return new Produto(descricao,preco,quantidade);
    }

    public static CadastrarProdutoRequest gerarCadastarProdutoRequest(){

        Long produtoId = 1L;
        String descricao = "Sabonete";
        Double preco = 10.0;
        Integer quantidade= 1;

        return new CadastrarProdutoRequest(produtoId ,descricao,preco,quantidade);
    }

    public static ProdutoResponse gerarProdutoResponse(){

        Long produtoId = 1L;
        String descricao = "Sabonete";
        Double preco = 10.0;
        Integer quantidade= 1;

        return new ProdutoResponse(produtoId ,descricao,preco,quantidade);
    }

    public static ProdutoResponse gerarProdutoResponseAtualizado(){

        Long produtoId = 1L;
        String descricao = "Sabonete";
        Double preco = 10.0;
        Integer quantidade= 1;

        return new ProdutoResponse(produtoId ,descricao,preco,quantidade);
    }



    public static AtualizarProdutoRequest gerarAtualizarProdutoRequest(){

      //  Long produtoId = 1L;
        String descricao = "Sabonete";
        Double preco = 10.0;
        Integer quantidade= 1;

        return new AtualizarProdutoRequest(descricao,preco,quantidade);
    }

    public static ProdutoEntity gerarProdutoEntity(){

        Long produtoId = 1L;
        String descricao = "Sabonete";
        Double preco = 10.0;
        Integer quantidade= 1;

        return new ProdutoEntity(produtoId ,descricao,preco,quantidade);
    }


}
