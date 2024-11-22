package br.com.fiap.tc.catalogoprodutos_api.catalogoprodutos_api.infra.adapter.repository;

import br.com.fiap.tc.catalogoprodutos_api.catalogoprodutos_api.domain.entity.Produto;
import br.com.fiap.tc.catalogoprodutos_api.catalogoprodutos_api.domain.entity.validation.ValidationProduto;
import br.com.fiap.tc.catalogoprodutos_api.catalogoprodutos_api.domain.gateway.CadastrarProdutoInterface;
import br.com.fiap.tc.catalogoprodutos_api.catalogoprodutos_api.infra.entity.ProdutoEntity;
import br.com.fiap.tc.catalogoprodutos_api.catalogoprodutos_api.infra.repository.ProdutoRepository;
import br.com.fiap.tc.catalogoprodutos_api.catalogoprodutos_api.infra.repository.mapper.ProdutoEntityMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;


@RequiredArgsConstructor
@Component
public class CadastrarProdutoAdapter implements CadastrarProdutoInterface {

    private final ProdutoRepository produtoRepository;
    private final ProdutoEntityMapper produtoEntityMapper;

    @Override
    public Produto cadastraProduto(Produto produto){

        ValidationProduto validator = new ValidationProduto(produto);

        validator.validar();


        ProdutoEntity produtoEntity=produtoEntityMapper.toEntity(produto);
        ProdutoEntity novoProduto = produtoRepository.save(produtoEntity);
        return produtoEntityMapper.toProdutoResponse(novoProduto);

    }







}
