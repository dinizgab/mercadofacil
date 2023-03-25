package com.ufcg.psoft.mercadofacil.lote;

import com.ufcg.psoft.mercadofacil.produto.Produto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Lote {
    private Long id;
    private Produto produto;
    private int numeroDeItens; 
}
