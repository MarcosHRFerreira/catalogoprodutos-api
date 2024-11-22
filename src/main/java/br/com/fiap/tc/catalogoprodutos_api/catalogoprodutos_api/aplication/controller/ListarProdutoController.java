package br.com.fiap.tc.catalogoprodutos_api.catalogoprodutos_api.aplication.controller;

import br.com.fiap.tc.catalogoprodutos_api.catalogoprodutos_api.domain.entity.Produto;
import br.com.fiap.tc.catalogoprodutos_api.catalogoprodutos_api.domain.gateway.ListarProdutoInterface;
import br.com.fiap.tc.catalogoprodutos_api.catalogoprodutos_api.domain.mapper.ProdutoDtoMapper;
import br.com.fiap.tc.catalogoprodutos_api.catalogoprodutos_api.domain.output.ProdutoResponse;
import br.com.fiap.tc.catalogoprodutos_api.catalogoprodutos_api.domain.usecase.ListarProdutoUseCase;
import br.com.fiap.tc.catalogoprodutos_api.catalogoprodutos_api.infra.entity.ProdutoEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/produtos")
public class ListarProdutoController {

    private final ListarProdutoInterface listarProdutoInterface;
    private final ListarProdutoUseCase listarProdutoUseCase;
    private final ProdutoDtoMapper produtoDtoMapper;

    @GetMapping
    public ResponseEntity<List<ProdutoResponse>>listarProdutos(){
        List<Produto> produtos = listarProdutoUseCase.listarProdutos();
        List<ProdutoResponse> listaClienteResponse = produtos.stream().map(produtoDtoMapper::toProdutoResponse).toList();

        return ResponseEntity.ok(listaClienteResponse);

    }

}
