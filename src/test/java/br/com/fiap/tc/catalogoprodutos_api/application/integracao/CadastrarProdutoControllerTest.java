package br.com.fiap.tc.catalogoprodutos_api.application.integracao;

import br.com.fiap.tc.catalogoprodutos_api.catalogoprodutos_api.aplication.controller.CadastrarProdutoController;
import br.com.fiap.tc.catalogoprodutos_api.catalogoprodutos_api.domain.entity.Produto;
import br.com.fiap.tc.catalogoprodutos_api.catalogoprodutos_api.domain.input.CadastrarProdutoRequest;
import br.com.fiap.tc.catalogoprodutos_api.catalogoprodutos_api.domain.mapper.ProdutoDtoMapper;
import br.com.fiap.tc.catalogoprodutos_api.catalogoprodutos_api.domain.output.ProdutoResponse;
import br.com.fiap.tc.catalogoprodutos_api.catalogoprodutos_api.domain.usecase.CadastrarProdutoUseCase;
import br.com.fiap.tc.catalogoprodutos_api.utils.ProdutoHelper;
import br.com.fiap.tc.catalogoprodutos_api.utils.generic.JsonStringHelper;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.net.URI;


import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

class CadastrarProdutoControllerTest {

    @Mock
    private CadastrarProdutoUseCase cadastrarProdutoUseCase;

    @Mock
    private ProdutoDtoMapper produtoDtoMapper;

    private MockMvc mockMvc;

    private AutoCloseable mock;

    @BeforeEach
    public void setUp(){
        mock= MockitoAnnotations.openMocks(this);
        CadastrarProdutoController controller = new CadastrarProdutoController(produtoDtoMapper, cadastrarProdutoUseCase);
        mockMvc= MockMvcBuilders.standaloneSetup(controller)
                .addFilter((request,response,chain) -> {
                    response.setCharacterEncoding("UTF-8");
                    chain.doFilter(request,response);
                }).build();
    }

    @AfterEach
    void tearDown()throws Exception{
        mock.close();
    }

    @Test
    void deveCadastrarProduto() throws Exception{
        //Arrange

        Produto produto = ProdutoHelper.gerarProdutoValido();
        ProdutoResponse produtoResponse = ProdutoHelper.gerarProdutoResponse();
        CadastrarProdutoRequest produtoRequest = ProdutoHelper.gerarCadastarProdutoRequest();

        URI uri = URI.create("http://localhost/produtos/" + produtoResponse.produtoId());

        when(produtoDtoMapper.toProduto(any(CadastrarProdutoRequest.class))).thenReturn(produto);
        when (cadastrarProdutoUseCase.cadastarProduto(any(Produto.class))).thenAnswer(answer -> answer.getArgument(0));
        when(produtoDtoMapper.toProdutoResponse(any(Produto.class))).thenReturn(produtoResponse);

        //Act e Assert
        mockMvc.perform(post("/produtos")
                .content(JsonStringHelper.asJsonString(produtoRequest))
                .contentType(MediaType.APPLICATION_JSON)
        )
                .andExpect(status().isCreated())
                .andExpect(header().string("Location",uri.toString()))
                .andExpect(jsonPath("$.produtoId").value(produtoResponse.produtoId()))
                .andExpect(jsonPath("$.descricao").value(produtoResponse.descricao()))
                .andExpect(jsonPath("$.preco").value(produtoResponse.preco()))
                .andExpect(jsonPath("$.quantidade").value(produtoResponse.quantidade()));

       verify(produtoDtoMapper,times(1)).toProduto(any(CadastrarProdutoRequest.class));
       verify(cadastrarProdutoUseCase,times(1)).cadastarProduto(any(Produto.class));
       verify(produtoDtoMapper,times(1)).toProdutoResponse(any(Produto.class));


    }

}
