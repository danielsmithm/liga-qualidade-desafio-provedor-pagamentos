package br.com.zup.edu.ligaqualidade.desafioprovadorpagamentos.modifique;

import br.com.zup.edu.ligaqualidade.desafioprovadorpagamentos.pronto.DadosRecebimentoAdiantado;
import br.com.zup.edu.ligaqualidade.desafioprovadorpagamentos.pronto.DadosTransacao;
import br.com.zup.edu.ligaqualidade.desafioprovadorpagamentos.pronto.MetodoPagamento;

import java.util.Map;

public interface ProcessadorPagamento {

    Map<MetodoPagamento, ProcessadorPagamento> IMPLEMENTATIONS_REGISTRY = Map.of(MetodoPagamento.CREDITO, new ProcessadorPagamentoCartaoCredito(),
            MetodoPagamento.DEBITO, new ProcessadorPagamentoCartaoDebito());

    static ProcessadorPagamento getProcessadorPagamentoApropriado(DadosTransacao dadosTransacao) {
        return IMPLEMENTATIONS_REGISTRY.get(dadosTransacao.metodo);
    }

    DadosProcessamentoPagamento processarPagamento(DadosTransacao dadosTransacao, DadosRecebimentoAdiantado dadosRecebimentoAdiantado);
}