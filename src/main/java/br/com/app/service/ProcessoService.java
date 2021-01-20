package br.com.app.service;

import java.time.LocalDateTime;

import javax.ejb.Stateless;
import javax.inject.Inject;

import br.com.app.model.Processo;
import br.com.app.model.enumerator.SituacaoProcessoEnum;
import br.com.app.persistence.ProcessoPersistence;

@Stateless
public class ProcessoService {

	@Inject
	private ProcessoPersistence persistence;

	public Processo salvar(Processo processo) {

		return persistence.salvar(processo);
	}

	public Processo montarProcesso(SituacaoProcessoEnum situacao) {
		return Processo.builder()
					  .dataCriacao(LocalDateTime.now())
					  .situacao(situacao)
					  .descricao(situacao.getDescricao())
					  .build();
	}
}
