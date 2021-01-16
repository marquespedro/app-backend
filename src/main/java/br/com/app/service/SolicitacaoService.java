package br.com.app.service;

import java.util.Objects;

import javax.ejb.Stateless;
import javax.inject.Inject;

import br.com.app.exception.AppException;
import br.com.app.exception.MensagemErro;
import br.com.app.model.Solicitacao;
import br.com.app.model.enumerator.TipoSolicitacaoEnum;
import br.com.app.service.strategy.SolicitacaoStrategy;
import br.com.app.strategy.SolicitacaoStrategyFactory;

@Stateless
public class SolicitacaoService {
	
	@Inject
	private SolicitacaoStrategyFactory strategyFactory;

	public Solicitacao criar(Solicitacao solicitacao) {
			
		return  obterStrategy(solicitacao).criar(solicitacao);
	}

	private SolicitacaoStrategy obterStrategy(Solicitacao solicitacao) {
		
		TipoSolicitacaoEnum tipo = TipoSolicitacaoEnum.comoEnum(solicitacao.getTipo().getCodigo());
		
		if(Objects.isNull(tipo)) {
			throw new AppException(new MensagemErro("tipo.solicitacao.invalido", solicitacao.getTipo().getCodigo().toString()));
		}
		
		return strategyFactory.getStrategy(tipo.getCodigo());
	}

	
}
