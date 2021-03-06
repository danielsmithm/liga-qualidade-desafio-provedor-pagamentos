package br.com.zup.edu.ligaqualidade.desafioprovadorpagamentos.modifique;

import br.com.zup.edu.ligaqualidade.desafioprovadorpagamentos.pronto.DadosTransacao;
import br.com.zup.edu.ligaqualidade.desafioprovadorpagamentos.pronto.MetodoPagamento;

import java.math.BigDecimal;
import java.time.LocalDate;
public class DadosTransacaoParser {

    public DadosTransacao recuperarDadosDaTransacao(String transacaoCSV){
        String[] split = transacaoCSV.split(",");

        BigDecimal valor = new BigDecimal(split[0]);
        MetodoPagamento metodoPagamento = MetodoPagamento.valueOf(split[1]);
        String numeroCartao = split[2];
        String nomeCartao = split[3];
        LocalDate validade = FormatadorData.parseData(split[4]);
        int cvv = Integer.parseInt(split[5]);
        int idTransacao = Integer.parseInt(split[6]);

        return new DadosTransacao(valor, metodoPagamento, numeroCartao, nomeCartao, validade, cvv, idTransacao);
    }
}