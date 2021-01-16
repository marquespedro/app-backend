package br.com.app.service.strategy;

import javax.ejb.Stateless;

import br.com.app.model.Solicitacao;
import br.com.app.model.enumerator.TipoSolicitacaoEnum;
import br.com.app.strategy.annotation.StrategySolicitacao;

@Stateless
@StrategySolicitacao(tipo = TipoSolicitacaoEnum.ALTERAR_PROPRIETARIO)
public class SolicitacaoAlterarProprietario implements SolicitacaoStrategy {

	@Override
	public Solicitacao criar(Solicitacao solicitacao) {

		return solicitacao;
	}

}
