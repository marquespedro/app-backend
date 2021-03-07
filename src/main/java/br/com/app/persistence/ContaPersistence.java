package br.com.app.persistence;

import java.util.Objects;

import javax.ejb.Stateless;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;

import br.com.app.model.Conta;

@Stateless
public class ContaPersistence extends PersistenceBase<Conta, Long> {

	public Conta salvar(Conta proprietario) {

		if (Objects.isNull(proprietario)) {
			return null;
		}

		return persistir(proprietario);
	}

	public Conta obterPorAgenciaNumeroConta(String agencia, String numeroConta) {

		TypedQuery<Conta> query = getEntityManager().createNamedQuery("Conta.PorAgenciaNumeroConta", Conta.class);
		
		query.setParameter("pAgencia", agencia);
		query.setParameter("pNumeroConta", numeroConta);
		
		try {

			return query.getSingleResult();
			
		} catch (NoResultException e) {
			
			return null;
		}
		
	
	}
}
