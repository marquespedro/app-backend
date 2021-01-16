package br.com.app.persistence;

import java.io.Serializable;
import java.util.Objects;

import javax.inject.Inject;
import javax.persistence.EntityManager;


import br.com.app.model.EntidadeBase;

public abstract class PersistenceBase <T extends EntidadeBase<K>, K extends Serializable> {

	@Inject
	private EntityManager manager;
	

	
    public T obterPorId(Class<T> tipo, K id) {
    	
    	if(Objects.isNull(id)) {
    		return null;
    	}
    	
    	return manager.find(tipo, id);
    }
}
