package com.ufcg.psoft.mercadofacil.lote;

import java.util.HashMap;
import java.util.List;

import org.springframework.stereotype.Repository;

@Repository
public class VolatilLoteRepository implements LoteRepository<Lote, Long> {
    private HashMap<Long, Lote> lotes = new HashMap<>();

    @Override
    public Lote save(Lote lote) {
        this.lotes.put(lote.getId(), lote);
        return this.lotes.get(lote.getId());
    }

    @Override
    public Lote find(Long id) {
        return this.lotes.get(id);
    }

    @Override
    public List<Lote> findAll() {
        return this.lotes.values().stream().toList();
    }

    @Override
    public Lote update(Lote lote) {
        this.lotes.remove(lote.getId());
        this.lotes.put(lote.getId(), lote);
        return this.lotes.get(lote.getId());
    }

    @Override
    public void delete(Lote lote) {
        this.lotes.remove(lote.getId());
    }

    @Override
    public void deleteAll() {
        this.lotes.clear();
    }
}
