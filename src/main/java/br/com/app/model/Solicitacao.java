package br.com.app.model;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import br.com.app.model.enumerator.SituacaoProcessoEnum;
import br.com.app.model.enumerator.TipoSolicitacaoEnum;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "solicitacao")
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
@Data
public class Solicitacao extends EntidadeBase<Long> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE , generator = "solicitacao_seq")
	@SequenceGenerator(name = "solicitacao_seq" , sequenceName = "solicitacao_seq")
	private Long id;

	@Column(name = "tipoSolicitacao")
	private TipoSolicitacaoEnum tipo;

	@JoinColumn(name = "id_imovel")
	@ManyToOne(fetch = FetchType.LAZY)
	private Imovel imovel;
	
	@JoinColumn(name = "id_proprietario")
	@ManyToOne(fetch = FetchType.LAZY)
	private Proprietario proprietario;

	@Column(name = "situacao_atual")
	private SituacaoProcessoEnum situacaoAtual;
	
	@JoinTable(name = "solicitacao_processos")
	@OneToMany
	private Set<Processo> processos;
	
	public void adicionarProcesso(Processo processo) {
	
		if(Objects.isNull(processo)) {
			return ;
		}
		
		if(this.processos == null || this.processos.isEmpty()) {
			this.processos = new HashSet<Processo>();			
		}
		
		this.situacaoAtual = processo.getSituacao();
		this.processos.add(processo);
	}
}
