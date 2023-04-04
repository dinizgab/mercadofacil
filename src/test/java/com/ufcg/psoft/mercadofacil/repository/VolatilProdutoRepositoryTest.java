package com.ufcg.psoft.mercadofacil.repository;

import static org.junit.jupiter.api.Assertions.*;

import com.ufcg.psoft.mercadofacil.model.Produto;
import com.ufcg.psoft.mercadofacil.utils.TestUtils;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@DisplayName("Testes do repositório de produtos")
public class VolatilProdutoRepositoryTest {
    @Autowired
    ProdutoRepository driver;

    Produto produto;

    @BeforeEach
    void setUp() {
        produto = TestUtils.criarProduto(10L, "Produto 1", "Fabricante 1", "1234567890123", 100.0);
    }
    @Test
    @DisplayName("Quando criar um produto válido")
    void testCriarProduto() {
        Produto resultado = driver.save(produto);

        assertNotNull(resultado);
        assertEquals("Produto 1", resultado.getNome());
    }
}
