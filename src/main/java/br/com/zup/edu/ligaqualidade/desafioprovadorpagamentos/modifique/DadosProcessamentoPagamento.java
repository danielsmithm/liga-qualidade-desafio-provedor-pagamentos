package br.com.zup.edu.ligaqualidade.desafioprovadorpagamentos.modifique;

import java.math.BigDecimal;
import java.time.LocalDate;

import static java.util.Objects.requireNonNull;

public class DadosProcessamentoPagamento {

    private final String status;
    private final BigDecimal valorOriginal;
    private final BigDecimal valorComDescontoDasTaxas;
    private final LocalDate dataRecebimento;

    public DadosProcessamentoPagamento(String status, BigDecimal valorOriginal, BigDecimal valorComDescontoDasTaxas, LocalDate dataRecebimento) {
        this.status = requireNonNull(status, "O status não pode ser nulo");
        this.valorOriginal = requireNonNull(valorOriginal, "O valor original não pode ser nulo");
        this.valorComDescontoDasTaxas = requireNonNull(valorComDescontoDasTaxas, "O valor com o desconto das taxas não pode ser nulo");
        this.dataRecebimento = requireNonNull(dataRecebimento, "A data de recebimento não pode ser nula");
    }

    public String[] asArray() {
        return new String[]{
                status,
                valorOriginal.toString(),
                valorComDescontoDasTaxas.toString(),
                FormatadorData.formatarData(dataRecebimento)
        };

    }

}