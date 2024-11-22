package br.com.fiap.tc.catalogoprodutos_api.catalogoprodutos_api.infra.config;

import br.com.fiap.tc.catalogoprodutos_api.catalogoprodutos_api.domain.gateway.ListarProdutoInterface;
import br.com.fiap.tc.catalogoprodutos_api.catalogoprodutos_api.domain.usecase.ListarProdutoUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ListarProdutoConfig {

    @Bean
    public ListarProdutoUseCase listarProdutoUseCase(
            ListarProdutoInterface listarProdutoInterface){
        return new ListarProdutoUseCase((listarProdutoInterface));
    }

}
