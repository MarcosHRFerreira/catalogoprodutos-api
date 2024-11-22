package br.com.fiap.tc.catalogoprodutos_api.catalogoprodutos_api.aplication.controller;

import br.com.fiap.tc.catalogoprodutos_api.catalogoprodutos_api.domain.output.ProdutoDeletadoResponse;
import br.com.fiap.tc.catalogoprodutos_api.catalogoprodutos_api.domain.usecase.DeletarProdutoUseCase;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@RestController
@RequestMapping("/produtos")

public class DeletarProdutoController {

    private  final DeletarProdutoUseCase deletarProdutoUseCase;

    @DeleteMapping("/{id}")
    public ResponseEntity<ProdutoDeletadoResponse>deletarProduto(@PathVariable Long id){

        boolean produtoFoiDeletado = deletarProdutoUseCase.deletarProduto(id);
        return  ResponseEntity.ok(new ProdutoDeletadoResponse(produtoFoiDeletado));

    }

}
