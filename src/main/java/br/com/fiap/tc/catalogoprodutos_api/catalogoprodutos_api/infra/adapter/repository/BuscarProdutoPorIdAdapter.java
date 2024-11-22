package br.com.fiap.tc.catalogoprodutos_api.catalogoprodutos_api.infra.adapter.repository;

import br.com.fiap.tc.catalogoprodutos_api.catalogoprodutos_api.domain.entity.Produto;
import br.com.fiap.tc.catalogoprodutos_api.catalogoprodutos_api.domain.gateway.BuscarProdutoPorIdInterface;
import br.com.fiap.tc.catalogoprodutos_api.catalogoprodutos_api.infra.entity.ProdutoEntity;
import br.com.fiap.tc.catalogoprodutos_api.catalogoprodutos_api.infra.repository.ProdutoRepository;
import br.com.fiap.tc.catalogoprodutos_api.catalogoprodutos_api.infra.repository.mapper.ProdutoEntityMapper;
import org.springframework.stereotype.Component;

@Component
public class BuscarProdutoPorIdAdapter implements BuscarProdutoPorIdInterface {

    private final ProdutoRepository produtoRepository;
    private final ProdutoEntityMapper produtoEntityMapper;


    public BuscarProdutoPorIdAdapter(ProdutoRepository produtoRepository, ProdutoEntityMapper produtoEntityMapper) {
        this.produtoRepository = produtoRepository;
        this.produtoEntityMapper = produtoEntityMapper;
    }

    @Override
    public Produto buscarProdutoPorId(Long id){
        ProdutoEntity produtoBuscado = produtoRepository.findById(id).orElse(null);
        return  produtoEntityMapper.toProdutoResponse(produtoBuscado);
    }

}
