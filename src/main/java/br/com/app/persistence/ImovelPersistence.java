package br.com.app.persistence;

import java.util.Objects;

import javax.ejb.Stateless;

import br.com.app.model.Imovel;

@Stateless
public class ImovelPersistence extends PersistenceBase<Imovel, Long> {

	
	public Imovel salvar(Imovel imovel) {
	
		if(Objects.isNull(imovel)) {
			return null;
		}
		
		return persist(imovel);
	} 
}
