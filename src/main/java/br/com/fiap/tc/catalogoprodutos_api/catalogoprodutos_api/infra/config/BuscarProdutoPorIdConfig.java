package br.com.fiap.tc.catalogoprodutos_api.catalogoprodutos_api.infra.config;

import br.com.fiap.tc.catalogoprodutos_api.catalogoprodutos_api.domain.gateway.BuscarProdutoPorIdInterface;
import br.com.fiap.tc.catalogoprodutos_api.catalogoprodutos_api.domain.usecase.BuscarProdutoPorIdUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BuscarProdutoPorIdConfig {
    @Bean
    public BuscarProdutoPorIdUseCase buscarProdutoPorIdUseCase(BuscarProdutoPorIdInterface buscarProdutoPorIdInterface){
        return  new BuscarProdutoPorIdUseCase(buscarProdutoPorIdInterface);
    }

}
