package br.com.fiap.tc.catalogoprodutos_api.domain.usecase.integracao;

import br.com.fiap.tc.catalogoprodutos_api.catalogoprodutos_api.CatalogoprodutosApiApplication;
import br.com.fiap.tc.catalogoprodutos_api.catalogoprodutos_api.domain.exception.ProdutoNotFoundException;
import br.com.fiap.tc.catalogoprodutos_api.catalogoprodutos_api.domain.usecase.DeletarProdutoUseCase;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

@SpringBootTest(classes = CatalogoprodutosApiApplication.class)
@ExtendWith(SpringExtension.class)
 class DeletarProdutoUseCaseIT {

    @Autowired
    private DeletarProdutoUseCase deletarProdutoUseCase;

    @Test
    void devePermitirDeletarProduto(){

        Long id=2L;

        //Act
        boolean produtoFoiDeletado = deletarProdutoUseCase.deletarProduto(id);

        //Assert
        assertThat(produtoFoiDeletado).isTrue();

    }

    @Test
    void deveGerarExcecao_Quando_IdNaoEncontrado(){
        Long id=100L;

        //Act e Assert
        assertThatThrownBy(()-> deletarProdutoUseCase.deletarProduto(id))
                .isInstanceOf(ProdutoNotFoundException.class)
                .hasMessage("Produto de id: " + id + " não encontrado.");

    }



}
