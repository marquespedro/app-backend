package br.com.app.service;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import br.com.app.model.Solicitacao;
import br.com.app.model.enumerator.SituacaoProcessoEnum;
import br.com.app.model.enumerator.TipoSolicitacaoEnum;
import br.com.app.persistence.SolicitacaoPersistence;
import br.com.app.service.solicitacao.SolicitacaoStrategy;
import br.com.app.strategy.SolicitacaoFactory;

@Stateless
public class SolicitacaoService {
	
	@Inject
	private SolicitacaoFactory strategyFactory;
	
	@Inject
	private SolicitacaoPersistence persistence;

	public Solicitacao criar(Solicitacao solicitacao) {
			
		SolicitacaoStrategy strategy = strategyFactory.getStrategy(solicitacao.getTipo().getCodigo());
		
		return strategy.criarStrategy(solicitacao);
	}


	public Solicitacao persistir(Solicitacao solicitacao) {
		
		persistence.persistir(solicitacao);
		
		return solicitacao;
	}
	
	public boolean jaExisteSolicitacaoAlterarProprietario(Long idProprietario) {
			
		List<Solicitacao> porSituacaoPorProprietario = persistence.obterPorSituacaoPorProprietarioPorTipo(SituacaoProcessoEnum.EM_ANDAMENTO, 
																										 idProprietario, 
																										 TipoSolicitacaoEnum.ALTERAR_PROPRIETARIO);
		
		
		return porSituacaoPorProprietario == null || porSituacaoPorProprietario.isEmpty() ? false : true;
	}
	
	
}
