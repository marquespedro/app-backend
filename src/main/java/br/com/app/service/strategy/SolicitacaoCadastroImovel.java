package br.com.app.service.strategy;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import br.com.app.model.Solicitacao;
import br.com.app.model.enumerator.TipoSolicitacaoEnum;
import br.com.app.persistence.SolicitacaoPersistence;
import br.com.app.strategy.annotation.StrategySolicitacao;

@Stateless
@StrategySolicitacao(tipo = TipoSolicitacaoEnum.CADASTRO_IMOVEL)
public class SolicitacaoCadastroImovel implements SolicitacaoStrategy{

	@EJB
	private SolicitacaoPersistence persistence;
	
	@Override
	public Solicitacao criar(Solicitacao solicitacao) {
		
		persistence.salvar(solicitacao);
		
		return solicitacao;
	}

}
