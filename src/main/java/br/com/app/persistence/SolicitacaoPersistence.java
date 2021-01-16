package br.com.app.persistence;

import java.util.Objects;

import javax.ejb.Stateless;

import br.com.app.model.Solicitacao;

@Stateless
public class SolicitacaoPersistence extends PersistenceBase<Solicitacao, Long> {

	
	public Solicitacao salvar(Solicitacao solicitacao) {
	
		if(Objects.isNull(solicitacao)) {
			return null;
		}
		
		return persist(solicitacao);
	} 
}
