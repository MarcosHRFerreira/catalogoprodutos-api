package br.com.fiap.tc.catalogoprodutos_api.catalogoprodutos_api.domain.usecase;

import br.com.fiap.tc.catalogoprodutos_api.catalogoprodutos_api.domain.entity.Produto;
import br.com.fiap.tc.catalogoprodutos_api.catalogoprodutos_api.domain.gateway.AtualizarProdutoInterface;

public class AtualizarProdutoUseCase {

    private final AtualizarProdutoInterface atualizarProdutoInterface;
    private final BuscarProdutoPorIdUseCase buscarProdutoPorIdUseCase;


    public AtualizarProdutoUseCase(AtualizarProdutoInterface atualizarProdutoInterface, BuscarProdutoPorIdUseCase buscarProdutoPorIdUseCase) {
        this.atualizarProdutoInterface = atualizarProdutoInterface;
        this.buscarProdutoPorIdUseCase = buscarProdutoPorIdUseCase;
    }

    public Produto atualizarProduto(Long id, Produto produto){
        Produto produtoBuscado=buscarProdutoPorIdUseCase.buscarProdutoPorId(id);

        produtoBuscado.setDescricao(produto.getDescricao());
        produtoBuscado.setPreco(produto.getPreco());
        produtoBuscado.setQuantidade(produto.getQuantidade());

        return atualizarProdutoInterface.atualizarProduto(id,produtoBuscado);

    }


}
