package br.com.app.service.solicitacao;

import javax.ejb.Stateless;
import javax.inject.Inject;

import br.com.app.exception.AppException;
import br.com.app.exception.mensagens.MensagemErro;
import br.com.app.model.Solicitacao;
import br.com.app.model.enumerator.SituacaoProcessoEnum;
import br.com.app.model.enumerator.TipoSolicitacaoEnum;
import br.com.app.service.ImovelService;
import br.com.app.service.SolicitacaoService;
import br.com.app.strategy.annotation.TipoSolicitacao;

@Stateless
@TipoSolicitacao(tipo = TipoSolicitacaoEnum.ALTERAR_PROPRIETARIO)
public class SolicitacaoAlterarProprietario extends SolicitacaoBase implements SolicitacaoStrategy {

	
	@Inject
	private ImovelService imovelService;
	
	@Inject
	private SolicitacaoService solicitacaoService;
	
	@Override
	public Solicitacao criarStrategy(Solicitacao solicitacao) {

		criar(solicitacao);

		Long idProprietario = solicitacao.getProprietario().getId();
		
		boolean existe = solicitacaoService.jaExisteSolicitacaoAlterarProprietario(idProprietario);
	
		if(existe) {
			throw new AppException(new MensagemErro("existe.solicitacao.ativa" , TipoSolicitacaoEnum.ALTERAR_PROPRIETARIO.toString(), 
																				 SituacaoProcessoEnum.EM_ANDAMENTO.getDescricao()));
		}
		
		imovelService.atribuirProprietario(solicitacao.getImovel() , idProprietario);
				
		return solicitacaoService.persistir(solicitacao);
	}

	

}
