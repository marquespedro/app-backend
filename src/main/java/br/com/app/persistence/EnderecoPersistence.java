package br.com.app.persistence;

import java.util.Objects;

import javax.ejb.Stateless;

import br.com.app.model.Endereco;

@Stateless
public class EnderecoPersistence extends PersistenceBase<Endereco, Long> {

	
	public Endereco salvar(Endereco endereco) {
	
		if(Objects.isNull(endereco)) {
			return null;
		}
		
		return persist(endereco);
	} 
}
