package com.ufcg.psoft.mercadofacil.model;

import com.ufcg.psoft.mercadofacil.model.Produto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Lote {
    private Long id;
    private Produto produto;
    private int numeroDeItens; 
}
