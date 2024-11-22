package br.com.fiap.tc.catalogoprodutos_api.catalogoprodutos_api.infra.adapter.repository;

import br.com.fiap.tc.catalogoprodutos_api.catalogoprodutos_api.domain.entity.Produto;
import br.com.fiap.tc.catalogoprodutos_api.catalogoprodutos_api.domain.gateway.AtualizarProdutoInterface;
import br.com.fiap.tc.catalogoprodutos_api.catalogoprodutos_api.infra.entity.ProdutoEntity;
import br.com.fiap.tc.catalogoprodutos_api.catalogoprodutos_api.infra.repository.ProdutoRepository;
import br.com.fiap.tc.catalogoprodutos_api.catalogoprodutos_api.infra.repository.mapper.ProdutoEntityMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class AtualizarProdutoAdapter implements AtualizarProdutoInterface {

    private final ProdutoRepository produtoRepository;
    private final ProdutoEntityMapper produtoEntityMapper;
    private final BuscarProdutoPorIdAdapter buscarProdutoPorIdAdapter;

    @Override
    public Produto atualizarProduto(Long id, Produto produto){
        ProdutoEntity produtoAtualizado = produtoRepository.save(produtoEntityMapper.toEntity(produto));

        return  produtoEntityMapper.toProdutoResponse(produtoAtualizado);
    }


}
