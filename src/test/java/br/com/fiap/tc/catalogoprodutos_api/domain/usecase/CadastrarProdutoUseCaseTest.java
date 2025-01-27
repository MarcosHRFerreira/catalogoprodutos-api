package br.com.fiap.tc.catalogoprodutos_api.domain.usecase;


import br.com.fiap.tc.catalogoprodutos_api.catalogoprodutos_api.domain.entity.Produto;
import br.com.fiap.tc.catalogoprodutos_api.catalogoprodutos_api.domain.gateway.CadastrarProdutoInterface;
import br.com.fiap.tc.catalogoprodutos_api.catalogoprodutos_api.domain.usecase.CadastrarProdutoUseCase;
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
 class CadastrarProdutoUseCaseTest {


    private CadastrarProdutoUseCase cadastrarProdutoUseCase;

    @Mock
    private CadastrarProdutoInterface cadastrarProdutoInterface;

    @BeforeEach
    public void setUp(){
        cadastrarProdutoUseCase=new CadastrarProdutoUseCase(cadastrarProdutoInterface);
    }

    @Test
    void deveCadastarProduto(){

        Produto produto = ProdutoHelper.gerarProdutoValido();

        when(cadastrarProdutoInterface.cadastraProduto(any(Produto.class))).thenReturn(produto);

        Produto produtocadastrado=cadastrarProdutoUseCase.cadastarProduto(produto);

        assertThat(produtocadastrado.getDescricao())
                .isEqualTo(produto.getDescricao());
        assertThat(produtocadastrado.getPreco())
                .isEqualTo(produto.getPreco());
        assertThat(produtocadastrado.getQuantidade())
                .isEqualTo(produto.getQuantidade());

        verify(cadastrarProdutoInterface,times(1)).cadastraProduto(any(Produto.class));

    }

}
