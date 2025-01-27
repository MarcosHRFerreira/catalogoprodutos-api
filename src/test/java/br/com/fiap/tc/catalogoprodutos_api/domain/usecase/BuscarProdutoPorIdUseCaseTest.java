package br.com.fiap.tc.catalogoprodutos_api.domain.usecase;

import br.com.fiap.tc.catalogoprodutos_api.catalogoprodutos_api.domain.entity.Produto;
import br.com.fiap.tc.catalogoprodutos_api.catalogoprodutos_api.domain.exception.ProdutoNotFoundException;
import br.com.fiap.tc.catalogoprodutos_api.catalogoprodutos_api.domain.gateway.BuscarProdutoPorIdInterface;
import br.com.fiap.tc.catalogoprodutos_api.catalogoprodutos_api.domain.usecase.BuscarProdutoPorIdUseCase;
import br.com.fiap.tc.catalogoprodutos_api.utils.ProdutoHelper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;


import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
 class BuscarProdutoPorIdUseCaseTest {

    private BuscarProdutoPorIdUseCase buscarProdutoPorIdUseCase;

    @Mock
    private BuscarProdutoPorIdInterface buscarProdutoPorIdInterface;

    @BeforeEach
    public void setUp(){
        this.buscarProdutoPorIdUseCase=new BuscarProdutoPorIdUseCase(buscarProdutoPorIdInterface);
    }

    @Test
    void deveBuscarProdutoPorId(){

        //Arrange
        Produto produto = ProdutoHelper.gerarProdutoValido();

        Long id= 1L;
        produto.setProdutoId(id);

        when(buscarProdutoPorIdInterface.buscarProdutoPorId(id)).thenReturn(produto);

        //Act
        Produto produtoBuscado = buscarProdutoPorIdUseCase.buscarProdutoPorId(id);

        // Assert
        assertThat(produtoBuscado)
                .isNotNull()
                .isInstanceOf(Produto.class)
                .isEqualTo(produto);

    }

    @Test
    void deveGerarExcecao_QuandoBuscaProduto_IDNaoExiste(){

        //Arrange
        Long id = 100L;

        when(buscarProdutoPorIdInterface.buscarProdutoPorId(any(Long.class))).thenThrow(new ProdutoNotFoundException("Produto de id: " + id + " não encontrado."));

        // Act
        assertThatThrownBy(()->buscarProdutoPorIdUseCase.buscarProdutoPorId(id))
                .isNotNull()
                .isInstanceOf(ProdutoNotFoundException.class)
                .hasMessage("Produto de id: " + id + " não encontrado.");

        verify(buscarProdutoPorIdInterface,times(1)).buscarProdutoPorId(any(Long.class));


    }



}
