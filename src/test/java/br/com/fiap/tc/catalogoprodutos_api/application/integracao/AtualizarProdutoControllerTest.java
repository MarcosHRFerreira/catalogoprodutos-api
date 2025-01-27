package br.com.fiap.tc.catalogoprodutos_api.application.integracao;

import br.com.fiap.tc.catalogoprodutos_api.catalogoprodutos_api.aplication.controller.AtualizarProdutoController;
import br.com.fiap.tc.catalogoprodutos_api.catalogoprodutos_api.aplication.handler.GlobalExceptionHandler;
import br.com.fiap.tc.catalogoprodutos_api.catalogoprodutos_api.domain.entity.Produto;
import br.com.fiap.tc.catalogoprodutos_api.catalogoprodutos_api.domain.exception.ProdutoNotFoundException;
import br.com.fiap.tc.catalogoprodutos_api.catalogoprodutos_api.domain.input.AtualizarProdutoRequest;
import br.com.fiap.tc.catalogoprodutos_api.catalogoprodutos_api.domain.mapper.ProdutoDtoMapper;
import br.com.fiap.tc.catalogoprodutos_api.catalogoprodutos_api.domain.output.ProdutoResponse;
import br.com.fiap.tc.catalogoprodutos_api.catalogoprodutos_api.domain.usecase.AtualizarProdutoUseCase;
import br.com.fiap.tc.catalogoprodutos_api.utils.ProdutoHelper;
import br.com.fiap.tc.catalogoprodutos_api.utils.generic.JsonStringHelper;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;



import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


class AtualizarProdutoControllerTest {

    @Mock
    private AtualizarProdutoUseCase atualizarProdutoUseCase;

    @Mock
    private ProdutoDtoMapper produtoDtoMapper;

    private AutoCloseable mock;

    private MockMvc mockMvc;

    @BeforeEach
    public void setUp(){
        mock= MockitoAnnotations.openMocks(this);
        AtualizarProdutoController controller = new AtualizarProdutoController(produtoDtoMapper, atualizarProdutoUseCase);
        mockMvc = MockMvcBuilders.standaloneSetup(controller)
                .setControllerAdvice(new GlobalExceptionHandler())
                .addFilter((request,response,chain)->{
                    response.setCharacterEncoding("UTF-8");
                    chain.doFilter(request,response);
                }).build();
    }

    @AfterEach
    public void tearDown()throws Exception{
        mock.close();
    }
    @Test
    void deveAtualizarProduto()throws Exception{
        //Arrange
        Long id = 1L;
        Produto produto = ProdutoHelper.gerarProdutoValido();

        produto.setDescricao("Sabonete");
        produto.setPreco(10.0);
        produto.setQuantidade(1);

        ProdutoResponse produtoResponse = ProdutoHelper.gerarProdutoResponseAtualizado();
        AtualizarProdutoRequest produtoRequest = ProdutoHelper.gerarAtualizarProdutoRequest();

        when(atualizarProdutoUseCase.atualizarProduto(any(Long.class),any(Produto.class))).thenReturn(produto);
        when(produtoDtoMapper.toProduto(any(AtualizarProdutoRequest.class))).thenReturn(produto);
        when(produtoDtoMapper.toProdutoResponse(any(Produto.class))).thenReturn(produtoResponse);

        //Act & Assert
        mockMvc.perform(put("/produtos/{id}", id)
                .content(JsonStringHelper.asJsonString(produtoRequest))
                .contentType(MediaType.APPLICATION_JSON)
        )
                        .andExpect(status().isOk())
                        .andExpect(jsonPath("$.produtoId").value(id))
                        .andExpect(jsonPath("$.descricao").value(produto.getDescricao()))
                        .andExpect(jsonPath("$.preco").value(produto.getPreco()))
                        .andExpect(jsonPath("$.quantidade").value(produto.getQuantidade()));

        verify(atualizarProdutoUseCase,times(1)).atualizarProduto(any(Long.class),any(Produto.class));
        verify(produtoDtoMapper,times(1)).toProduto(any(AtualizarProdutoRequest.class));
        verify(produtoDtoMapper,times(1)).toProdutoResponse(any(Produto.class));
    }

    @Test
    void deveGerarExcecao_QuandoAtualizar_IdNaoExistente() throws Exception{
        //Arrange
        Long id=100L;
        Produto produto = ProdutoHelper.gerarProdutoValido();
        produto.setDescricao("Sabonete");
        produto.setPreco(10.0);
        produto.setQuantidade(1);
        AtualizarProdutoRequest produtoRequest=ProdutoHelper.gerarAtualizarProdutoRequest();

        when(produtoDtoMapper.toProduto(any(AtualizarProdutoRequest.class))).thenReturn(produto);
        when(atualizarProdutoUseCase.atualizarProduto(any(Long.class),any(Produto.class))).thenThrow(new ProdutoNotFoundException("Produto de id: " + id + " não encontrado."));
        when(produtoDtoMapper.toProdutoResponse(any(Produto.class))).thenReturn(null);

        //Act & Assert
        mockMvc.perform(put("/produtos/{id}",id)
                .content(JsonStringHelper.asJsonString(produtoRequest))
                .contentType(MediaType.APPLICATION_JSON)
        )
                .andExpect(status().isNotFound())
                .andExpect(jsonPath("$.erro").value("Produto de id: " + id + " não encontrado."))
                .andExpect(jsonPath("$.status").value(HttpStatus.NOT_FOUND.value()))
                .andExpect(jsonPath("$.horario").exists())
                .andExpect(jsonPath("$.rota").value("/produtos/" +id));

        verify(produtoDtoMapper,times(1)).toProduto(any(AtualizarProdutoRequest.class));
        verify(atualizarProdutoUseCase,times(1)).atualizarProduto(any(Long.class),any(Produto.class));
        verify(produtoDtoMapper,never()).toProdutoResponse(null);





    }

}
