package com.ufcg.psoft.mercadofacil.service;

import com.ufcg.psoft.mercadofacil.model.Produto;
import com.ufcg.psoft.mercadofacil.repository.VolatilProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProdutoAlterarServiceImpl implements ProdutoAlterarService {
    @Autowired
    VolatilProdutoRepository produtoRepository;

    @Override
    public Produto alterar(Produto produtoAlterado) {
        if (produtoAlterado.getPreco() <= 0) throw new RuntimeException("Preco invalido!");

        if (!validadorCodigoBarra(produtoAlterado.getCodigoBarra())) throw new RuntimeException("Codigo de barras invalido");

        return this.produtoRepository.update(produtoAlterado);
    }

    private boolean validadorCodigoBarra(String codigoBarra) {
        Integer numeroValidador = Integer.parseInt(String.valueOf(codigoBarra.charAt(codigoBarra.length() - 1)));
        int total1 = 0;
        int total2 = 0;

        for (int i = 0; i < codigoBarra.length() / 2; i++) {
            total1 += Integer.parseInt(String.valueOf(codigoBarra.charAt(i)));
            total2 += Integer.parseInt(String.valueOf(codigoBarra.charAt(i + 1)));
        }

        int result = total2 * 3 + total1 + numeroValidador;

        return result % 10 == 0;
    }
}
