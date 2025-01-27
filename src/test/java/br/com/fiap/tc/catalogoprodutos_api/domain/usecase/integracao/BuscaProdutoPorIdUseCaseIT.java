package br.com.fiap.tc.catalogoprodutos_api.domain.usecase.integracao;

import br.com.fiap.tc.catalogoprodutos_api.catalogoprodutos_api.CatalogoprodutosApiApplication;
import br.com.fiap.tc.catalogoprodutos_api.catalogoprodutos_api.domain.entity.Produto;
import br.com.fiap.tc.catalogoprodutos_api.catalogoprodutos_api.domain.exception.ProdutoNotFoundException;
import br.com.fiap.tc.catalogoprodutos_api.catalogoprodutos_api.domain.usecase.BuscarProdutoPorIdUseCase;
import io.cucumber.java.nl.Stel;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

@SpringBootTest(classes = CatalogoprodutosApiApplication.class)
@ExtendWith(SpringExtension.class)
 class BuscaProdutoPorIdUseCaseIT {

    @Autowired
    private BuscarProdutoPorIdUseCase buscarProdutoPorIdUseCase;

    @Test
    void deveBuscarProdutoPorIdUseCase(){

        //Arrange
        Long id=1L;

        //Act
        Produto produto = buscarProdutoPorIdUseCase.buscarProdutoPorId(id);

        //Assert
        assertThat(produto)
                .isNotNull()
                .isInstanceOf(Produto.class);

        assertThat(produto.getProdutoId())
                .isNotNull()
                .isEqualTo(id);

        assertThat(produto.getDescricao())
                .isNotEmpty()
                .isEqualTo("Sabonete");

        assertThat(produto.getPreco())
                .isEqualTo(10.0);

        assertThat(produto.getQuantidade())
                .isEqualTo(1);

    }

    @Test
    void deveGerarExcecao_QuandoBuscarProdutoPorIdNaoExiste(){

        Long id = 100L;

        //Act e Assert
        assertThatThrownBy(()-> buscarProdutoPorIdUseCase.buscarProdutoPorId(id))
                .isInstanceOf(ProdutoNotFoundException.class)
                .hasMessage("Produto de id: " + id + " não encontrado.");

    }


}
