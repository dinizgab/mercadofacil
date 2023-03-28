package com.ufcg.psoft.mercadofacil.repository;

import com.ufcg.psoft.mercadofacil.model.Produto;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;

@Repository
public class VolatilProdutoRepository implements ProdutoRepository<Produto, Long> {
    HashMap<Long, Produto> produtoRepository;

    @Override
    public Produto save(Produto produto) {
        return null;
    }

    @Override
    public Produto find(Long id) {
        return this.produtoRepository.get(id);
    }

    @Override
    public List<Produto> findAll() {
        return null;
    }

    @Override
    public Produto update(Produto produto) {
        this.produtoRepository.remove(produto.getId());
        this.produtoRepository.put(produto.getId(), produto);
        return this.produtoRepository.get(produto.getId());
    }

    @Override
    public void delete(Produto produto) {

    }

    @Override
    public void deleteAll() {

    }
}
