package com.ufcg.psoft.mercadofacil.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class ProdutoValidarCodigoBarraTest {
    @Autowired
    private ValidarCodigoBarraServiceImpl driver;

    @Test
    @DisplayName("Código de barras válido")
    void codigoBarraValido() {
        boolean resultado = this.driver.validarCodigoBarra("4012345678901");

        assertTrue(resultado);
    }

    @Test
    @DisplayName("Código de barras inválido")
    void codigoBarraInvalido() {
        RuntimeException error = assertThrows(
                RuntimeException.class,
                () -> driver.validarCodigoBarra("1234567890123"));

        assertEquals("Codigo de barras invalido", error.getMessage());
    }
}
