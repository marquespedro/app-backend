package br.com.app.strategy;

import javax.enterprise.util.AnnotationLiteral;

import br.com.app.model.enumerator.TipoSolicitacaoEnum;
import br.com.app.strategy.annotation.StrategySolicitacao;

@SuppressWarnings(value = "all")
public class SolicitacaoStrategyLiteral extends AnnotationLiteral<StrategySolicitacao> implements StrategySolicitacao{

	private static final long serialVersionUID = 1L;

	private TipoSolicitacaoEnum tipoSolicitacao;
	
	public SolicitacaoStrategyLiteral(TipoSolicitacaoEnum tipo) {
		this.tipoSolicitacao = tipo;
	}
	
	@Override
	public TipoSolicitacaoEnum tipo() {		
		return this.tipoSolicitacao;
	}

	
}
