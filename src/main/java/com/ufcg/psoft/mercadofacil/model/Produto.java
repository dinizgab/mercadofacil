package com.ufcg.psoft.mercadofacil.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Builder;
import lombok.Data;

@Data
@Entity
@Builder
public class Produto {
    @Id
    private long id;
    private String nome;
    private double preco;
    private String codigoBarra;
    private String fabricante;
}
