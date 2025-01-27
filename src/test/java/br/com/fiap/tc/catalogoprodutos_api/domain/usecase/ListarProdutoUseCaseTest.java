package br.com.fiap.tc.catalogoprodutos_api.domain.usecase;

import br.com.fiap.tc.catalogoprodutos_api.catalogoprodutos_api.domain.entity.Produto;
import br.com.fiap.tc.catalogoprodutos_api.catalogoprodutos_api.domain.gateway.ListarProdutoInterface;
import br.com.fiap.tc.catalogoprodutos_api.catalogoprodutos_api.domain.usecase.ListarProdutoUseCase;
import br.com.fiap.tc.catalogoprodutos_api.utils.ProdutoHelper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
 class ListarProdutoUseCaseTest {

    private ListarProdutoUseCase listarProdutoUseCase;

    @Mock
    private ListarProdutoInterface listarProdutoInterface;

    @BeforeEach
    public void setUp(){
        listarProdutoUseCase = new ListarProdutoUseCase(listarProdutoInterface);
    }

    @Test
    void deveListarProdutos(){

        //Arrange
        Produto produto1 = ProdutoHelper.gerarProdutoValido();
        Produto produto2 = ProdutoHelper.gerarProdutoValido();

        List<Produto> listaDeProduto=List.of(produto1,produto2);

        when(listarProdutoInterface.listarProdutos()).thenReturn(listaDeProduto);

        //Act
       List<Produto>produtos=listarProdutoUseCase.listarProdutos();

        //Assert
        assertThat(produtos)
                .isNotNull()
                .isNotEmpty()
                .hasSizeGreaterThan(1)
                .containsExactlyInAnyOrder(produto1,produto2);

        verify(listarProdutoInterface,times(1)).listarProdutos();

    }

}
