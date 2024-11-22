package br.com.fiap.tc.catalogoprodutos_api.catalogoprodutos_api.domain.mapper;

import br.com.fiap.tc.catalogoprodutos_api.catalogoprodutos_api.domain.entity.Produto;
import br.com.fiap.tc.catalogoprodutos_api.catalogoprodutos_api.domain.input.AtualizarProdutoRequest;
import br.com.fiap.tc.catalogoprodutos_api.catalogoprodutos_api.domain.input.CadastrarProdutoRequest;
import br.com.fiap.tc.catalogoprodutos_api.catalogoprodutos_api.domain.output.ProdutoResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ProdutoDtoMapper {

    /**
     * @param cadastrarProdutoRequest
     * @return
     */
    @Mapping(target = "produtoId", ignore = true)
    Produto toProduto(CadastrarProdutoRequest cadastrarProdutoRequest);

    /**
     * @param atualizarProdutoRequest
     * @return
     */
    @Mapping(target = "produtoId", ignore = true)
    Produto toProduto(AtualizarProdutoRequest atualizarProdutoRequest);

    /**
     * @param produto
     * @return
     */
    ProdutoResponse toProdutoResponse(Produto produto);

}
