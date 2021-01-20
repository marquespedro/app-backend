package br.com.app.persistence;

import java.util.Objects;

import javax.ejb.Stateless;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;

import br.com.app.model.Endereco;

@Stateless
public class EnderecoPersistence extends PersistenceBase<Endereco, Long> {

	public Endereco salvar(Endereco endereco) {

		if (Objects.isNull(endereco)) {
			return null;
		}

		return persist(endereco);
	}

	public Endereco obterPorCep(String cep) {

		TypedQuery<Endereco> query = getEntityManager().createNamedQuery("Endereco.findByCep", Endereco.class);

		query.setParameter("pCep", cep);

		try {
			return query.getSingleResult();
		} catch (NoResultException e) {
			return null;
		}

	}
}
