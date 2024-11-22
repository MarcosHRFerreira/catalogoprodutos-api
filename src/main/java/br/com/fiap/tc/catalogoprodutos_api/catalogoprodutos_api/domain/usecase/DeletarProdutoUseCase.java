package br.com.fiap.tc.catalogoprodutos_api.catalogoprodutos_api.domain.usecase;

import br.com.fiap.tc.catalogoprodutos_api.catalogoprodutos_api.domain.gateway.DeletarProdutoInterface;

public class DeletarProdutoUseCase {

    private final DeletarProdutoInterface deletarProdutoInterface;
    private final BuscarProdutoPorIdUseCase buscarProdutoPorIdUseCase;


    public DeletarProdutoUseCase(DeletarProdutoInterface deletarProdutoInterface, BuscarProdutoPorIdUseCase buscarProdutoPorIdUseCase) {
        this.deletarProdutoInterface = deletarProdutoInterface;
        this.buscarProdutoPorIdUseCase = buscarProdutoPorIdUseCase;
    }

    public boolean deletarProduto(Long id){

        buscarProdutoPorIdUseCase.buscarProdutoPorId(id);

        return deletarProdutoInterface.deletarProduto(id);

    }


}
