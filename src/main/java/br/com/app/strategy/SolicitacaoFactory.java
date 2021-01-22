package br.com.app.strategy;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

import javax.enterprise.context.Dependent;
import javax.enterprise.inject.Any;
import javax.enterprise.inject.Instance;
import javax.inject.Inject;

import br.com.app.exception.AppException;
import br.com.app.exception.mensagens.MensagemErro;
import br.com.app.model.enumerator.TipoSolicitacaoEnum;
import br.com.app.service.solicitacao.SolicitacaoStrategy;

@Dependent
public class SolicitacaoFactory {
	
	@Inject
	@Any
	private Instance<SolicitacaoStrategy> solicitacaoStrategy;
	
	
	private Map<Integer, TipoSolicitacaoEnum> strategies;

	public SolicitacaoFactory() {
		
		this.strategies = new HashMap<>();
		
		for (TipoSolicitacaoEnum tipo : TipoSolicitacaoEnum.values()) {
			this.strategies.put(tipo.getCodigo(), tipo);
		}

	}

	public SolicitacaoStrategy getStrategy(Integer codigo) {

		TipoSolicitacaoEnum tipo = this.strategies.get(codigo);
				
		if(Objects.isNull(tipo)) {
			throw new AppException(new MensagemErro("tipo.solicitacao.invalido", codigo.toString()));
		}
			
		SolicitacaoAnnotationLiteral literal = new SolicitacaoAnnotationLiteral(tipo);
		
		Instance<SolicitacaoStrategy> strategyInstance = this.solicitacaoStrategy.select(literal);
	
		return strategyInstance.get();
	}

}
