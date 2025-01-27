package br.com.fiap.tc.catalogoprodutos_api.domain.entity;


import br.com.fiap.tc.catalogoprodutos_api.catalogoprodutos_api.domain.entity.Produto;
import br.com.fiap.tc.catalogoprodutos_api.utils.ProdutoHelper;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class ProdutoTest {
    @Test
    void deveCriarProduto(){
        Produto produto = ProdutoHelper.gerarProdutoValido();

        assertThat(produto)
                .isNotNull()
                .isInstanceOf(Produto.class);

        assertThat(produto.getDescricao())
                .isNotEmpty()
                .isNotNull();

        assertThat(produto.getPreco())
                .isNotNull();

        assertThat((produto.getQuantidade()))
                .isNotNull();

    }
}
