package br.com.app.persistence;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import br.com.app.exception.AppException;
import br.com.app.exception.MensagemErro;
import br.com.app.model.EntidadeBase;

public abstract class PersistenceBase<T extends EntidadeBase<K>, K extends Serializable> {

	@PersistenceContext(unitName = "appPersistenceUnit")
	private EntityManager manager;

	public T find(Class<T> tipo, K id) {

		if (Objects.isNull(id)) {
			return null;
		}

		return manager.find(tipo, id);
	}
	
	public T persist(T entitiy) {

		if (Objects.isNull(entitiy)) {
			throw new AppException(new MensagemErro("falha.ao.gravar.dado"));
		}

		manager.persist(entitiy);
		
		return entitiy;
	}
	
	public EntityManager getEntityManager() {
		return this.manager;
	}
}
