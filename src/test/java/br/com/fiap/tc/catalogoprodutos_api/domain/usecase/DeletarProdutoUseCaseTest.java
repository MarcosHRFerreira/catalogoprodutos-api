package br.com.fiap.tc.catalogoprodutos_api.domain.usecase;

import br.com.fiap.tc.catalogoprodutos_api.catalogoprodutos_api.domain.entity.Produto;
import br.com.fiap.tc.catalogoprodutos_api.catalogoprodutos_api.domain.gateway.DeletarProdutoInterface;
import br.com.fiap.tc.catalogoprodutos_api.catalogoprodutos_api.domain.usecase.BuscarProdutoPorIdUseCase;
import br.com.fiap.tc.catalogoprodutos_api.catalogoprodutos_api.domain.usecase.DeletarProdutoUseCase;
import br.com.fiap.tc.catalogoprodutos_api.utils.ProdutoHelper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;


import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
 class DeletarProdutoUseCaseTest {

    private DeletarProdutoUseCase deletarProdutoUseCase;

    @Mock
    private DeletarProdutoInterface deletarProdutoInterface;

    @Mock
    private BuscarProdutoPorIdUseCase buscarProdutoPorIdUseCase;

    @BeforeEach
    public void setUp(){
        this.deletarProdutoUseCase=new DeletarProdutoUseCase(deletarProdutoInterface,buscarProdutoPorIdUseCase);
    }

    @Test
    void deveDeletarProdutoPorId(){

        //Arrange

        Long id=1L;
        Produto produtobuscado= ProdutoHelper.gerarProdutoValido();

        produtobuscado.setProdutoId(id);

        when(buscarProdutoPorIdUseCase.buscarProdutoPorId(any(Long.class))).thenReturn(produtobuscado);
        when(deletarProdutoInterface.deletarProduto(any(Long.class))).thenReturn(true);

        //Act
        boolean produtoDeletado = deletarProdutoUseCase.deletarProduto(id);

        //Assert
        assertThat(produtoDeletado).isTrue();
        verify(buscarProdutoPorIdUseCase,times(1)).buscarProdutoPorId(any(Long.class));
        verify(deletarProdutoInterface,times(1)).deletarProduto(any(Long.class));


    }


}
