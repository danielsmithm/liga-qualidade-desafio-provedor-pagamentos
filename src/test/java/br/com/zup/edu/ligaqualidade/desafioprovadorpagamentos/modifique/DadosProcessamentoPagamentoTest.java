package br.com.zup.edu.ligaqualidade.desafioprovadorpagamentos.modifique;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class DadosProcessamentoPagamentoTest {

    @Test
    @DisplayName("Deve gerar um array de strings com os dados do processamento")
    void deveGerarUmArrayDeStringsComOsDadosDoProcessamento() {
        DadosProcessamentoPagamento dadosProcessamentoPagamento = new DadosProcessamentoPagamento("pago", new BigDecimal("100.0"), new BigDecimal("97.0"), LocalDate.of(2021, 3, 6));

        String[] strings = dadosProcessamentoPagamento.asArray();
        assertAll("Dados do array estão corretos e na ordem certa", () -> {
            assertEquals("pago", strings[0]);
            assertEquals("100.0", strings[1]);
            assertEquals("97.0", strings[2]);
            assertEquals("06/03/2021", strings[3]);
        });

    }
}