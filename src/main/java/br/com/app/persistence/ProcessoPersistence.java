package br.com.app.persistence;

import java.util.Objects;

import javax.ejb.Stateless;

import br.com.app.model.Processo;

@Stateless
public class ProcessoPersistence extends PersistenceBase<Processo, Long> {

	public Processo salvar(Processo processo) {

		if (Objects.isNull(processo)) {
			return null;
		}

		return persistir(processo);
	}

}
