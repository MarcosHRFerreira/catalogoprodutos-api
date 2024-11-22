package br.com.fiap.tc.catalogoprodutos_api.catalogoprodutos_api.infra.config;

import br.com.fiap.tc.catalogoprodutos_api.catalogoprodutos_api.domain.gateway.DeletarProdutoInterface;
import br.com.fiap.tc.catalogoprodutos_api.catalogoprodutos_api.domain.usecase.BuscarProdutoPorIdUseCase;
import br.com.fiap.tc.catalogoprodutos_api.catalogoprodutos_api.domain.usecase.DeletarProdutoUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DeletarProdutoConfig {

    @Bean
    public DeletarProdutoUseCase deletarProdutoUseCase(
            DeletarProdutoInterface deletarProdutoInterface,
            BuscarProdutoPorIdUseCase buscarProdutoPorIdUseCase
    ){
        return new DeletarProdutoUseCase(deletarProdutoInterface,buscarProdutoPorIdUseCase);
    }
}
