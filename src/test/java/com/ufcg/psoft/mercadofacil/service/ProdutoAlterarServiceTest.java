package com.ufcg.psoft.mercadofacil.service;

import com.ufcg.psoft.mercadofacil.model.Produto;
import com.ufcg.psoft.mercadofacil.repository.ProdutoRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest
@AutoConfigureMockMvc
@DisplayName("Testes do servico de alteracao de produto")
public class ProdutoAlterarServiceTest {
    @Autowired
    private ProdutoAlterarService driver;
    @Autowired
    private ProdutoRepository produtoRepository;
    private Produto produto;

    @BeforeEach
    void setup() {
        produto = produtoRepository.save(Produto.builder()
                .codigoBarra("7899137500104")
                .nome("Produto Dez")
                .fabricante("Empresa Dez")
                .preco(450.00)
                .build()
        );
    }

    @Test
    @DisplayName("Quando altera o nome de um produto")
    void alterarNomeTest() {
        produto.setNome("Produto alterado");

        Produto produtoAlterado = driver.alterar(produto);

        assertEquals("Produto alterado", produtoAlterado.getNome());
    }

    @Test
    @DisplayName("Quando altera o fabricante de um produto")
    void alterarFabricanteTest() {
        produto.setNome("Fabricante alterado");

        Produto produtoAlterado = driver.alterar(produto);

        assertEquals("Fabricante alterado", produtoAlterado.getFabricante());
    }

    @Test
    @DisplayName("Alterar preco com um preco valido")
    void precoValidoTest() {
        produto.setPreco(20.6);

        Produto produtoAlterado = driver.alterar(produto);

        assertEquals(20.6, produtoAlterado.getPreco());
    }

    @Test
    @DisplayName("Quando o preco eh <= 0")
    void precoInvalidoTest() {
        produto.setPreco(0);
        RuntimeException error = assertThrows(
                RuntimeException.class,
                () -> driver.alterar(produto)
        );

        assertEquals("Preco invalido!", error.getMessage());
    }

    @Test
    @DisplayName("Codigo de barra valido")
    void codigoBarraValidoTest() {
        produto.setCodigoBarra("4012345678901");

        Produto produtoAlterado = driver.alterar(produto);
        assertEquals("4012345678901", produtoAlterado.getCodigoBarra());
    }

    @Test
    @DisplayName("Codigo de barras invalido")
    void codigoBarraInvalidoTest() {
        produto.setCodigoBarra("1234567890123");

        RuntimeException error =
                assertThrows(RuntimeException.class,
                        () -> driver.alterar(produto)
                );
        assertEquals("Codigo de barras invalido", error.getMessage());
    }
}
