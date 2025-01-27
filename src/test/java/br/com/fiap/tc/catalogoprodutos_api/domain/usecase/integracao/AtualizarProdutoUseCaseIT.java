package br.com.fiap.tc.catalogoprodutos_api.domain.usecase.integracao;

import br.com.fiap.tc.catalogoprodutos_api.catalogoprodutos_api.CatalogoprodutosApiApplication;
import br.com.fiap.tc.catalogoprodutos_api.catalogoprodutos_api.domain.entity.Produto;
import br.com.fiap.tc.catalogoprodutos_api.catalogoprodutos_api.domain.usecase.AtualizarProdutoUseCase;
import br.com.fiap.tc.catalogoprodutos_api.utils.ProdutoHelper;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(classes = CatalogoprodutosApiApplication.class)
@ExtendWith(SpringExtension.class)
public class AtualizarProdutoUseCaseIT {

    @Autowired
    private AtualizarProdutoUseCase atualizarProdutoUseCase;

    @Test
    void atualizarProduto(){

        Produto produtoBody = ProdutoHelper.gerarProdutoValido();

        Long id=2L;

        //Act
        Produto produtoAtualizado = atualizarProdutoUseCase.atualizarProduto(id,produtoBody);

        //Assert
        assertThat(produtoAtualizado)
                .isNotNull()
                .isInstanceOf(Produto.class);

        assertThat(produtoAtualizado.getDescricao())
                .isEqualTo(produtoBody.getDescricao());

        assertThat(produtoAtualizado.getPreco())
                .isEqualTo(produtoBody.getPreco());

        assertThat(produtoAtualizado.getQuantidade())
                .isEqualTo(produtoBody.getQuantidade());

        assertThat(produtoAtualizado.getProdutoId())
                .isNotNull()
                .isPositive()
                .isEqualTo(id);

    }


}
