package br.com.app.service.strategy;

import javax.inject.Inject;

import br.com.app.model.Processo;
import br.com.app.model.Solicitacao;
import br.com.app.model.enumerator.SituacaoProcessoEnum;
import br.com.app.service.ProcessoService;

public abstract class SolicitacaoBase {

	@Inject
	private ProcessoService processoService;
	
	public Solicitacao criar(Solicitacao solicitacao) {
		
		Processo processo = processoService.montarProcesso(SituacaoProcessoEnum.EM_ANDAMENTO);
		
		processoService.salvar(processo);
		
		solicitacao.adicionarProcesso(processo);
		
		return solicitacao;
	}
	
}
