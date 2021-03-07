package br.com.app.persistence;

import java.util.Objects;

import javax.ejb.Stateless;

import br.com.app.model.Cliente;

@Stateless
public class ClientePersistence extends PersistenceBase<Cliente, Long> {

	
	public Cliente salvar(Cliente imovel) {
	
		if(Objects.isNull(imovel)) {
			return null;
		}
		
		return persistir(imovel);
	} 
}
