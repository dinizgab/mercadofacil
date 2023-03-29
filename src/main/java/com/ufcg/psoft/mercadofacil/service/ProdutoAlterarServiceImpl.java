package com.ufcg.psoft.mercadofacil.service;

import com.ufcg.psoft.mercadofacil.model.Produto;
import com.ufcg.psoft.mercadofacil.repository.VolatilProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProdutoAlterarServiceImpl implements ProdutoAlterarService {
    @Autowired
    VolatilProdutoRepository produtoRepository;
    @Autowired
    ValidarCodigoBarraService validador;

    @Override
    public Produto alterar(Produto produtoAlterado) throws RuntimeException {
        if (produtoAlterado.getPreco() <= 0) throw new RuntimeException("Preco invalido!");

        validador.validarCodigoBarra(produtoAlterado.getCodigoBarra());

        return this.produtoRepository.update(produtoAlterado);
    }
}
