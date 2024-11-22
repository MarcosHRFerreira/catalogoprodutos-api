package br.com.fiap.tc.catalogoprodutos_api.catalogoprodutos_api.aplication.controller;


import br.com.fiap.tc.catalogoprodutos_api.catalogoprodutos_api.domain.entity.Produto;
import br.com.fiap.tc.catalogoprodutos_api.catalogoprodutos_api.domain.input.CadastrarProdutoRequest;
import br.com.fiap.tc.catalogoprodutos_api.catalogoprodutos_api.domain.mapper.ProdutoDtoMapper;
import br.com.fiap.tc.catalogoprodutos_api.catalogoprodutos_api.domain.output.ProdutoResponse;
import br.com.fiap.tc.catalogoprodutos_api.catalogoprodutos_api.domain.usecase.CadastrarProdutoUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RequiredArgsConstructor
@RestController
@RequestMapping("/produtos")
public class CadastrarProdutoController {

    private final ProdutoDtoMapper produtoDtoMapper;
    private final CadastrarProdutoUseCase cadastrarProdutoUseCase;

    @PostMapping
    public ResponseEntity<ProdutoResponse> cadastarProduto(@RequestBody CadastrarProdutoRequest cadastrarProdutoRequest){

        Produto produto = produtoDtoMapper.toProduto(cadastrarProdutoRequest);

        Produto produtocadastrado = cadastrarProdutoUseCase.cadastarProduto(produto);

        ProdutoResponse produtoResponse=produtoDtoMapper.toProdutoResponse(produtocadastrado);

        URI uri = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(produtoResponse.produtoId())
                .toUri();

        return ResponseEntity.created(uri).body(produtoResponse);

    }

}
