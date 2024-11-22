package br.com.fiap.tc.catalogoprodutos_api.catalogoprodutos_api.aplication.controller;


import br.com.fiap.tc.catalogoprodutos_api.catalogoprodutos_api.domain.entity.Produto;
import br.com.fiap.tc.catalogoprodutos_api.catalogoprodutos_api.domain.input.AtualizarProdutoRequest;
import br.com.fiap.tc.catalogoprodutos_api.catalogoprodutos_api.domain.mapper.ProdutoDtoMapper;
import br.com.fiap.tc.catalogoprodutos_api.catalogoprodutos_api.domain.output.ProdutoResponse;
import br.com.fiap.tc.catalogoprodutos_api.catalogoprodutos_api.domain.usecase.AtualizarProdutoUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/produtos")
public class AtualizarProdutoController {

    private final ProdutoDtoMapper produtoDtoMapper;
    private final AtualizarProdutoUseCase atualizarProdutoUseCase;

    @PutMapping("/{id}")
    public ResponseEntity<ProdutoResponse>atualizarProduto(@PathVariable Long id,
                                                           @RequestBody AtualizarProdutoRequest atualizarProdutoRequest){
        Produto produtoAtualizado =atualizarProdutoUseCase.atualizarProduto(id,produtoDtoMapper.toProduto(atualizarProdutoRequest));

        ProdutoResponse produtoResponse=produtoDtoMapper.toProdutoResponse(produtoAtualizado);

        return ResponseEntity.ok(produtoResponse);

    }


}
