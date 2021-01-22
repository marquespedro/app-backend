package br.com.app.strategy;

import javax.enterprise.util.AnnotationLiteral;

import br.com.app.model.enumerator.TipoSolicitacaoEnum;
import br.com.app.strategy.annotation.TipoSolicitacao;

@SuppressWarnings(value = "all")
public class SolicitacaoAnnotationLiteral extends AnnotationLiteral<TipoSolicitacao> implements TipoSolicitacao{

	private static final long serialVersionUID = 1L;

	private TipoSolicitacaoEnum tipoSolicitacao;
	
	public SolicitacaoAnnotationLiteral(TipoSolicitacaoEnum tipo) {
		this.tipoSolicitacao = tipo;
	}
	
	@Override
	public TipoSolicitacaoEnum tipo() {		
		return this.tipoSolicitacao;
	}

	
}
