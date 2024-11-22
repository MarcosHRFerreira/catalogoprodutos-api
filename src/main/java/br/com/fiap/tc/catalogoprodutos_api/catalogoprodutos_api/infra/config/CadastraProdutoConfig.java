package br.com.fiap.tc.catalogoprodutos_api.catalogoprodutos_api.infra.config;

import br.com.fiap.tc.catalogoprodutos_api.catalogoprodutos_api.domain.gateway.CadastrarProdutoInterface;
import br.com.fiap.tc.catalogoprodutos_api.catalogoprodutos_api.domain.usecase.CadastrarProdutoUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CadastraProdutoConfig {

    @Bean
    public CadastrarProdutoUseCase cadastrarProdutoUseCase(CadastrarProdutoInterface cadastrarProdutoInterface){
        return new CadastrarProdutoUseCase(cadastrarProdutoInterface);
    }

}
