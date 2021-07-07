package br.com.app.persistence;

import java.util.Objects;

import javax.ejb.Stateless;
import javax.persistence.NoResultException;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import br.com.app.dto.EnderecoDTO;
import br.com.app.dto.PaginacaoDTO;
import br.com.app.model.Endereco;

@Stateless
public class EnderecoPersistence extends PersistenceBase<Endereco, Long> {

	public Endereco salvar(Endereco endereco) {

		if (Objects.isNull(endereco)) {
			return null;
		}

		return persistir(endereco);
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

	@SuppressWarnings("unchecked")
	public PaginacaoDTO<EnderecoDTO> consultarPaginado(PaginacaoDTO<EnderecoDTO> dto) {
		
		Query query = getEntityManager().createQuery("FROM Endereco");
		
		query.setFirstResult(dto.getStart());
		query.setMaxResults(dto.getPageSize());
		
		Long total = (Long) getEntityManager().createQuery("SELECT COUNT (e) FROM Endereco e").getSingleResult();
		
		dto.setTotalResults(total.intValue());
		
		dto.setList(query.getResultList());
		
		return dto;
	}
}
