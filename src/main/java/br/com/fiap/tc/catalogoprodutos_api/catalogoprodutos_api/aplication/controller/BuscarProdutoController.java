package br.com.fiap.tc.catalogoprodutos_api.catalogoprodutos_api.aplication.controller;


import br.com.fiap.tc.catalogoprodutos_api.catalogoprodutos_api.domain.entity.Produto;
import br.com.fiap.tc.catalogoprodutos_api.catalogoprodutos_api.domain.mapper.ProdutoDtoMapper;
import br.com.fiap.tc.catalogoprodutos_api.catalogoprodutos_api.domain.output.ProdutoResponse;
import br.com.fiap.tc.catalogoprodutos_api.catalogoprodutos_api.domain.usecase.BuscarProdutoPorIdUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/produtos")
public class BuscarProdutoController {

    private final ProdutoDtoMapper produtoDtoMapper;
    private final BuscarProdutoPorIdUseCase buscarProdutoPorIdUseCase;

    @GetMapping("/{id}")
    public ResponseEntity<ProdutoResponse>buscarProduto(@PathVariable Long id){
           Produto produtoBuscado=buscarProdutoPorIdUseCase.buscarProdutoPorId(id);
           return ResponseEntity.ok(produtoDtoMapper.toProdutoResponse(produtoBuscado));

    }

}
