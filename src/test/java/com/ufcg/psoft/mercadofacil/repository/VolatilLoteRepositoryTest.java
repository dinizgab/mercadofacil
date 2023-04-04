package com.ufcg.psoft.mercadofacil.repository;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.ufcg.psoft.mercadofacil.model.Lote;
import com.ufcg.psoft.mercadofacil.model.Produto;

@SpringBootTest
@DisplayName("Testes do repositorio de lotes")
class VolatilLoteRepositoryTest {

   @Autowired
   LoteRepository driver;

   Lote lote;
   Lote resultado;
   Produto produto;

   @BeforeEach
   void setup() {
       produto = Produto.builder()
               .id(1L)
               .nome("Produto Base")
               .codigoBarra("123456789")
               .fabricante("Fabricante Base")
               .preco(125.36)
               .build();
       lote = Lote.builder()
               .id(1L)
               .numeroDeItens(100)
               .produto(produto)
               .build();
   }

   @AfterEach
   void tearDown() {
       produto = null;
       driver.deleteAll();
   }

   @Test
   @DisplayName("Adicionar o primeiro Lote no repositorio de dados")
   void salvarPrimeiroLote() {
       resultado = driver.save(lote);

       assertEquals(driver.findAll().size(),1);
       assertEquals(resultado.getId().longValue(), lote.getId().longValue());
       assertEquals(resultado.getProduto(), produto);
   }

   @Test
   @DisplayName("Adicionar o segundo Lote (ou posterior) no repositorio de dados")
   void salvarSegundoLoteOuPosterior() {
       Produto produtoExtra = Produto.builder()
               .id(2L)
               .nome("Produto Extra")
               .codigoBarra("987654321")
               .fabricante("Fabricante Extra")
               .preco(125.36)
               .build();
       Lote loteExtra = Lote.builder()
               .id(1L)
               .numeroDeItens(100)
               .produto(produtoExtra)
               .build();
       driver.save(lote);

       resultado = driver.save(loteExtra);

       assertEquals(driver.findAll().size(),1);
       assertEquals(resultado.getId().longValue(), loteExtra.getId().longValue());
       assertEquals(resultado.getProduto(), produtoExtra);
   }

   @Test
   void findOneLoteTest() {
       Lote resultado = driver.findById(1L).get();

       assertEquals(resultado.getId(), 1L);
       assertEquals(resultado.getProduto(), produto);
       assertEquals(resultado.getNumeroDeItens(), 100);
   }

   @Test
   void deleteOneValueTest() {
       driver.save(lote);
       assertEquals(driver.findAll().size(), 1);

       driver.delete(lote);
       assertEquals(driver.findAll().size(), 0);
   }

   @Test
   void deleteAllTest() {
       Produto produtoExtra = Produto.builder()
               .id(2L)
               .nome("Produto Extra")
               .codigoBarra("987654321")
               .fabricante("Fabricante Extra")
               .preco(125.36)
               .build();
       Lote loteExtra = Lote.builder()
               .id(1L)
               .numeroDeItens(100)
               .produto(produtoExtra)
               .build();

       driver.save(loteExtra);
       assertEquals(driver.findAll().size(), 1);

       driver.deleteAll();
       assertEquals(driver.findAll().size(), 0);
   }
}
