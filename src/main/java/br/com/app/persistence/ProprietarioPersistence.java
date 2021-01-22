package br.com.app.persistence;

import java.util.Objects;

import javax.ejb.Stateless;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;

import br.com.app.model.Proprietario;

@Stateless
public class ProprietarioPersistence extends PersistenceBase<Proprietario, Long> {

	public Proprietario salvar(Proprietario proprietario) {

		if (Objects.isNull(proprietario)) {
			return null;
		}

		return persistir(proprietario);
	}

	public Proprietario obterPorCpf(String cpf) {

		TypedQuery<Proprietario> query = getEntityManager().createNamedQuery("Proprietario.findByCpf", Proprietario.class);
		
		query.setParameter("pCpf", cpf);
		
		try {

			return query.getSingleResult();
			
		} catch (NoResultException e) {
			
			return null;
		}
		
	
	}
}
