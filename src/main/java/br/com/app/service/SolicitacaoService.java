package br.com.app.service;

import javax.ejb.Stateless;
import javax.inject.Inject;

import br.com.app.model.Solicitacao;
import br.com.app.service.strategy.SolicitacaoStrategy;
import br.com.app.strategy.SolicitacaoStrategyFactory;

@Stateless
public class SolicitacaoService {
	
	@Inject
	private SolicitacaoStrategyFactory strategyFactory;

	public Solicitacao criar(Solicitacao solicitacao) {
			
		SolicitacaoStrategy strategy = strategyFactory.getStrategy(solicitacao.getTipo().getCodigo());
		
		return strategy.criar(solicitacao);
	}


	
}
