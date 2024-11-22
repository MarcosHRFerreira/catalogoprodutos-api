package br.com.fiap.tc.catalogoprodutos_api.catalogoprodutos_api.infra.entity;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;

@AllArgsConstructor
@NoArgsConstructor
@RequiredArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "produto")
public class ProdutoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long produtoId;
    @NonNull
    private String descricao;
    @NonNull
    private Double preco;
    @NonNull
    private Integer quantidade;

}
