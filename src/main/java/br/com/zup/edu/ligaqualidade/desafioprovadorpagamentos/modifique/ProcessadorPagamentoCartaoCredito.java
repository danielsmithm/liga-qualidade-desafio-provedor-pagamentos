package br.com.zup.edu.ligaqualidade.desafioprovadorpagamentos.modifique;

import br.com.zup.edu.ligaqualidade.desafioprovadorpagamentos.pronto.DadosRecebimentoAdiantado;
import br.com.zup.edu.ligaqualidade.desafioprovadorpagamentos.pronto.DadosTransacao;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.Period;

public class ProcessadorPagamentoCartaoCredito implements ProcessadorPagamento {

    public static final String STATUS_AGUARDANDO_LIBERACAO_FUNDOS = "aguardando_liberacao_fundos";

    @Override
    public DadosProcessamentoPagamento processarPagamento(DadosTransacao dadosTransacao, DadosRecebimentoAdiantado dadosRecebimentoAdiantado) {
        return new DadosProcessamentoPagamento(STATUS_AGUARDANDO_LIBERACAO_FUNDOS, dadosTransacao.valor, calcularValorComDescontoDasTaxasOperacionais(dadosTransacao), calcularDataRecebimento());
    }

    private BigDecimal calcularValorComDescontoDasTaxasOperacionais(DadosTransacao dadosTransacao) {
        BigDecimal valorTransacao = dadosTransacao.valor;

        BigDecimal valorDesconto = valorTransacao.multiply(new BigDecimal("0.05"));

        return valorTransacao.subtract(valorDesconto);
    }

    private LocalDate calcularDataRecebimento() {
        return LocalDate.now().plus(Period.ofDays(30));
    }

}