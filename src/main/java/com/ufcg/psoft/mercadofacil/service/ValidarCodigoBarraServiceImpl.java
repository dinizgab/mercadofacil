package com.ufcg.psoft.mercadofacil.service;

import org.springframework.stereotype.Service;

@Service
public class ValidarCodigoBarraServiceImpl implements ValidarCodigoBarraService {
    @Override
    public boolean validarCodigoBarra(String codigoBarra) throws RuntimeException {
        Integer numeroValidador = Integer.parseInt(String.valueOf(codigoBarra.charAt(codigoBarra.length() - 1)));
        int total1 = 0;
        int total2 = 0;

        for (int i = 0; i < codigoBarra.length() / 2; i++) {
            total1 += Integer.parseInt(String.valueOf(codigoBarra.charAt(i)));
            total2 += Integer.parseInt(String.valueOf(codigoBarra.charAt(i + 1)));
        }

        int resultado = total2 * 3 + total1 + numeroValidador;

        if (resultado % 10 != 0) {
            throw new RuntimeException("Codigo de barras invalido");
        }

        return true;
    }
}
