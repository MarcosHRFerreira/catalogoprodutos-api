package br.com.fiap.tc.catalogoprodutos_api.catalogoprodutos_api.infra.adapter.repository;

import br.com.fiap.tc.catalogoprodutos_api.catalogoprodutos_api.domain.entity.Produto;
import br.com.fiap.tc.catalogoprodutos_api.catalogoprodutos_api.domain.gateway.ListarProdutoInterface;
import br.com.fiap.tc.catalogoprodutos_api.catalogoprodutos_api.infra.repository.ProdutoRepository;
import br.com.fiap.tc.catalogoprodutos_api.catalogoprodutos_api.infra.repository.mapper.ProdutoEntityMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class ListarProdutoAdapter implements ListarProdutoInterface {

    private final ProdutoRepository produtoRepository;
    private final ProdutoEntityMapper produtoEntityMapper;

    @Override
    public List<Produto>listarProdutos(){
        return produtoRepository.findAll().stream().map(produtoEntityMapper::toProdutoResponse).toList();
    }


}
