package com.ufcg.psoft.mercadofacil.utils;

import com.ufcg.psoft.mercadofacil.model.Produto;

public class TestUtils {

    public static Produto criarProduto(Long id, String nome, String fabricante, String codigoDeBarra, Double preco) {
        return Produto.builder()
                .id(id)
                .nome(nome)
                .fabricante(fabricante)
                .codigoBarra(codigoDeBarra)
                .preco(preco)
                .build();
    }
}
