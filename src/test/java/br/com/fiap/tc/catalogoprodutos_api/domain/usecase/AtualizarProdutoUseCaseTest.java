package br.com.fiap.tc.catalogoprodutos_api.domain.usecase;

import br.com.fiap.tc.catalogoprodutos_api.catalogoprodutos_api.domain.entity.Produto;
import br.com.fiap.tc.catalogoprodutos_api.catalogoprodutos_api.domain.exception.ProdutoNotFoundException;
import br.com.fiap.tc.catalogoprodutos_api.catalogoprodutos_api.domain.gateway.AtualizarProdutoInterface;
import br.com.fiap.tc.catalogoprodutos_api.catalogoprodutos_api.domain.usecase.AtualizarProdutoUseCase;
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
class AtualizarProdutoUseCaseTest {

    private AtualizarProdutoUseCase atualizarProdutoUseCase;

    @Mock
    private AtualizarProdutoInterface atualizarProdutoInterface;

    @Mock
    private BuscarProdutoPorIdUseCase buscarProdutoPorIdUseCase;

    @BeforeEach
    void setUp(){
        this.atualizarProdutoUseCase=new AtualizarProdutoUseCase(atualizarProdutoInterface,buscarProdutoPorIdUseCase);
    }

    @Test
    void deveAtualizarProduto(){

        Produto produtoBuscado = ProdutoHelper.gerarProdutoValido();
        Produto produtoBody = ProdutoHelper.gerarProdutoValido();

        Long id=1L;

        produtoBody.setDescricao("Bola");
        produtoBody.setPreco(10.0);
        produtoBody.setQuantidade(1);

        doReturn(produtoBuscado)
                .when(buscarProdutoPorIdUseCase).buscarProdutoPorId(any(Long.class));
        when(atualizarProdutoInterface.atualizarProduto(any(Long.class), any(Produto.class))).thenAnswer(answer -> answer.getArgument(1));

        Produto produtoAtualizado = atualizarProdutoUseCase.atualizarProduto(id,produtoBody);

        assertThat(produtoAtualizado)
                .isNotNull()
                .isInstanceOf(Produto.class);

        assertThat(produtoAtualizado.getDescricao())
                .isNotEmpty()
                .isEqualTo("Bola");

        assertThat(produtoAtualizado.getPreco())
                .isEqualTo(10.0);

        assertThat((produtoAtualizado.getQuantidade()))
                .isEqualTo(1);

        verify(buscarProdutoPorIdUseCase,times(1)).buscarProdutoPorId(any(Long.class));
        verify(atualizarProdutoInterface, times(1)).atualizarProduto(any(Long.class), any(Produto.class));

    }

    @Test
    void deveGerarExcecao_QuandoAtualizarUsuario_IdDoUsuarioNaoExiste() {

        Produto produtoBody = ProdutoHelper.gerarProdutoValido();

        Long id=2L;

        produtoBody.setDescricao("Bola");
        produtoBody.setPreco(10.0);
        produtoBody.setQuantidade(1);

        when(buscarProdutoPorIdUseCase.buscarProdutoPorId(any(Long.class)))
                .thenThrow(new ProdutoNotFoundException("Produto de id: " + id + " não encontrado."));

        assertThatThrownBy(() -> atualizarProdutoUseCase.atualizarProduto(id,produtoBody))
                .hasMessage("Produto de id: " + id + " não encontrado.");

        verify(buscarProdutoPorIdUseCase,times(1)).buscarProdutoPorId(any(Long.class));
        verify(atualizarProdutoInterface,never()).atualizarProduto(any(Long.class),any(Produto.class));

    }

}
