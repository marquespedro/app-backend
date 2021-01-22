package br.com.app.service.solicitacao;

import javax.ejb.Stateless;
import javax.inject.Inject;

import br.com.app.model.Solicitacao;
import br.com.app.model.enumerator.TipoSolicitacaoEnum;
import br.com.app.persistence.SolicitacaoPersistence;
import br.com.app.service.ImovelService;
import br.com.app.strategy.annotation.TipoSolicitacao;

@Stateless
@TipoSolicitacao(tipo = TipoSolicitacaoEnum.CADASTRO_IMOVEL)
public class SolicitacaoCadastroImovel extends SolicitacaoBase implements SolicitacaoStrategy{

	@Inject
	private SolicitacaoPersistence persistence;
	
	@Inject
	private ImovelService imovelService;

	@Override
	public Solicitacao criarStrategy(Solicitacao solicitacao) {
		
		criar(solicitacao);
		
		imovelService.salvar(solicitacao.getImovel());
					
		return persistence.salvar(solicitacao);
	}

}
