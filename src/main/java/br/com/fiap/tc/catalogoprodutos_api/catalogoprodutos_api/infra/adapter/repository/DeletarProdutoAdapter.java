package br.com.fiap.tc.catalogoprodutos_api.catalogoprodutos_api.infra.adapter.repository;

import br.com.fiap.tc.catalogoprodutos_api.catalogoprodutos_api.domain.gateway.DeletarProdutoInterface;
import br.com.fiap.tc.catalogoprodutos_api.catalogoprodutos_api.infra.repository.ProdutoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class DeletarProdutoAdapter implements DeletarProdutoInterface {

    private final ProdutoRepository produtoRepository;

    @Override
    public boolean deletarProduto(Long id){
        produtoRepository.deleteById(id);
        return true;
    }


}
