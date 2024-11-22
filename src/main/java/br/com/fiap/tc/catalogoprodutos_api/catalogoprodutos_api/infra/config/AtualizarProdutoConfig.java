package br.com.fiap.tc.catalogoprodutos_api.catalogoprodutos_api.infra.config;

import br.com.fiap.tc.catalogoprodutos_api.catalogoprodutos_api.domain.gateway.AtualizarProdutoInterface;
import br.com.fiap.tc.catalogoprodutos_api.catalogoprodutos_api.domain.usecase.AtualizarProdutoUseCase;
import br.com.fiap.tc.catalogoprodutos_api.catalogoprodutos_api.domain.usecase.BuscarProdutoPorIdUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AtualizarProdutoConfig {

    @Bean
    public AtualizarProdutoUseCase atualizarProdutoUseCase(
            AtualizarProdutoInterface atualizarProdutoInterface,
            BuscarProdutoPorIdUseCase buscarProdutoPorIdUseCase){

        return new AtualizarProdutoUseCase(atualizarProdutoInterface,buscarProdutoPorIdUseCase);

    }

}
