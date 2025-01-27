package br.com.fiap.tc.catalogoprodutos_api.domain.usecase.integracao;

import br.com.fiap.tc.catalogoprodutos_api.catalogoprodutos_api.CatalogoprodutosApiApplication;
import br.com.fiap.tc.catalogoprodutos_api.catalogoprodutos_api.domain.entity.Produto;
import br.com.fiap.tc.catalogoprodutos_api.catalogoprodutos_api.domain.usecase.ListarProdutoUseCase;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(classes = CatalogoprodutosApiApplication.class)
@ExtendWith(SpringExtension.class)
class ListarProdutoUseCaseIT {

    @Autowired
    private ListarProdutoUseCase listarProdutoUseCase;

    @Test
    void devePermitirListarProdutos(){

        //Act
        List<Produto> listaProdutos = listarProdutoUseCase.listarProdutos();

        //Assert
        assertThat(listaProdutos)
                .isNotNull()
                .isNotEmpty()
                .hasSizeGreaterThan(19);

    }


}
