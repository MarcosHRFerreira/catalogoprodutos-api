package br.com.fiap.tc.catalogoprodutos_api.catalogoprodutos_api.infra.repository.mapper;


import br.com.fiap.tc.catalogoprodutos_api.catalogoprodutos_api.domain.entity.Produto;
import br.com.fiap.tc.catalogoprodutos_api.catalogoprodutos_api.infra.entity.ProdutoEntity;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface ProdutoEntityMapper {

    ProdutoEntityMapper INSTANCE = Mappers.getMapper(ProdutoEntityMapper.class);

    /**
     * @param produtoEntity
     * @return
     */
    Produto toProdutoResponse(ProdutoEntity produtoEntity);


    /**
     * @param produto
     * @return
     */
    ProdutoEntity toEntity(Produto produto);



}
