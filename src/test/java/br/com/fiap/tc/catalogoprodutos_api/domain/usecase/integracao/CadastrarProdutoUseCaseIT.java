package br.com.fiap.tc.catalogoprodutos_api.domain.usecase.integracao;

import br.com.fiap.tc.catalogoprodutos_api.catalogoprodutos_api.CatalogoprodutosApiApplication;
import br.com.fiap.tc.catalogoprodutos_api.catalogoprodutos_api.domain.entity.Produto;
import br.com.fiap.tc.catalogoprodutos_api.catalogoprodutos_api.domain.usecase.CadastrarProdutoUseCase;
import br.com.fiap.tc.catalogoprodutos_api.utils.ProdutoHelper;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(classes = CatalogoprodutosApiApplication.class)
@ExtendWith(SpringExtension.class)
class CadastrarProdutoUseCaseIT {
    @Autowired
    private CadastrarProdutoUseCase cadastrarProdutoUseCase;

    @Test
    void deveCadastarProduto(){

        //Arrange
        Produto produto = ProdutoHelper.gerarProdutoValido();

        //Act
        Produto produtoSalvo= cadastrarProdutoUseCase.cadastarProduto(produto);

        //Assert
        assertThat(produtoSalvo)
                .isNotNull()
                .isInstanceOf(Produto.class);

        assertThat(produtoSalvo.getProdutoId())
                .isNotNull()
                .isPositive();

        assertThat(produtoSalvo.getDescricao())
                .isEqualTo(produto.getDescricao());

        assertThat(produtoSalvo.getPreco())
                .isEqualTo(produto.getPreco());

        assertThat(produtoSalvo.getQuantidade())
                .isEqualTo(produto.getQuantidade());

    }


}
