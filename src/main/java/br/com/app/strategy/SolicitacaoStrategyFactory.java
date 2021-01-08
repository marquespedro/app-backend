package br.com.app.strategy;

import java.util.HashMap;
import java.util.Map;

import javax.enterprise.context.Dependent;
import javax.enterprise.inject.Any;
import javax.enterprise.inject.Instance;
import javax.inject.Inject;

import br.com.app.model.enumerator.TipoSolicitacaoEnum;
import br.com.app.service.strategy.SolicitacaoStrategy;

@Dependent
public class SolicitacaoStrategyFactory {
	
	@Inject
	@Any
	private Instance<SolicitacaoStrategy> solicitacaoStrategy;
	
	
	private Map<Integer, TipoSolicitacaoEnum> strategies;

	public SolicitacaoStrategyFactory() {
		
		this.strategies = new HashMap<>();
		
		for (TipoSolicitacaoEnum tipo : TipoSolicitacaoEnum.values()) {
			this.strategies.put(tipo.getCodigo(), tipo);
		}

	}

	public SolicitacaoStrategy getStrategy(Integer codigo) {

		TipoSolicitacaoEnum tipo = this.strategies.get(codigo);
		
		SolicitacaoStrategyLiteral literal = new SolicitacaoStrategyLiteral(tipo);
		
		Instance<SolicitacaoStrategy> algoritmoInstace = this.solicitacaoStrategy.select(literal);
	
		return algoritmoInstace.get();
	}

}
