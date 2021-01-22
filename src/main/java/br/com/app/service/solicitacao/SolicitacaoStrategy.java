package br.com.app.service.solicitacao;

import br.com.app.model.Solicitacao;

public interface SolicitacaoStrategy {

	Solicitacao criarStrategy(Solicitacao solicitacao);
}
