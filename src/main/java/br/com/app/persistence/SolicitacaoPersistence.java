package br.com.app.persistence;
import java.util.List;
import java.util.Objects;

import javax.ejb.Stateless;
import javax.persistence.TypedQuery;

import br.com.app.model.Solicitacao;
import br.com.app.model.enumerator.SituacaoProcessoEnum;
import br.com.app.model.enumerator.TipoSolicitacaoEnum;

@Stateless
public class SolicitacaoPersistence extends PersistenceBase<Solicitacao, Long> {

	
	public Solicitacao salvar(Solicitacao solicitacao) {
	
		if(Objects.isNull(solicitacao)) {
			return null;
		}
		
		return persistir(solicitacao);
	} 
	
	public List<Solicitacao> obterPorSituacaoPorProprietarioPorTipo(SituacaoProcessoEnum situacao , Long idProprietario , TipoSolicitacaoEnum tipo){
		
		String jqpl = "from Solicitacao s where s.situacaoAtual = :pSituacao and s.proprietario.id = :pIdProprietario and s.tipo = :pTipo";
		
		TypedQuery<Solicitacao> query = getEntityManager().createQuery(jqpl ,Solicitacao.class);
		
		query.setParameter("pSituacao", situacao);
		query.setParameter("pIdProprietario", idProprietario);
		query.setParameter("pTipo", tipo);
			
		return query.getResultList();
	}
}
