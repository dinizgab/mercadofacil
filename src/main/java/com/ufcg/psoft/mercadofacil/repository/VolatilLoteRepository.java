package com.ufcg.psoft.mercadofacil.repository;

import java.util.HashMap;
import java.util.List;

import com.ufcg.psoft.mercadofacil.model.Lote;
import org.springframework.stereotype.Repository;

@Repository
public class VolatilLoteRepository implements LoteRepository<Lote, Long> {
    private HashMap<Long, Lote> loteRepository = new HashMap<>();

    @Override
    public Lote save(Lote lote) {
        this.loteRepository.put(lote.getId(), lote);
        return this.loteRepository.get(lote.getId());
    }

    @Override
    public Lote find(Long id) {
        return this.loteRepository.get(id);
    }

    @Override
    public List<Lote> findAll() {
        return this.loteRepository.values().stream().toList();
    }

    @Override
    public Lote update(Lote lote) {
        this.loteRepository.remove(lote.getId());
        this.loteRepository.put(lote.getId(), lote);
        return this.loteRepository.get(lote.getId());
    }

    @Override
    public void delete(Lote lote) {
        this.loteRepository.remove(lote.getId());
    }

    @Override
    public void deleteAll() {
        this.loteRepository.clear();
    }
}
