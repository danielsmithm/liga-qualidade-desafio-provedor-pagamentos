package br.com.zup.edu.ligaqualidade.desafioprovadorpagamentos.modifique;

import br.com.zup.edu.ligaqualidade.desafioprovadorpagamentos.pronto.DadosRecebimentoAdiantado;
import br.com.zup.edu.ligaqualidade.desafioprovadorpagamentos.pronto.DadosTransacao;

import java.math.BigDecimal;
import java.time.LocalDate;

public class ProcessadorPagamentoCartaoDebito implements ProcessadorPagamento {

    public static final String STATUS_PAGO = "pago";

    @Override
    public DadosProcessamentoPagamento processarPagamento(DadosTransacao dadosTransacao, DadosRecebimentoAdiantado dadosRecebimentoAdiantado) {
        return new DadosProcessamentoPagamento(STATUS_PAGO, dadosTransacao.valor, calcularValorComDescontoDasTaxasOperacionais(dadosTransacao), calcularDataRecebimento());
    }

    private BigDecimal calcularValorComDescontoDasTaxasOperacionais(DadosTransacao dadosTransacao) {
        BigDecimal valorTransacao = dadosTransacao.valor;

        BigDecimal valorDoDesconto = valorTransacao.multiply(new BigDecimal("0.03"));

        return valorTransacao.subtract(valorDoDesconto);
    }

    private LocalDate calcularDataRecebimento() {
        return LocalDate.now();
    }

}