package br.com.app.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import br.com.app.model.enumerator.TipoSolicitacaoEnum;

@Entity
@Table(name = "solicitacao")
public class Solicitacao extends EntidadeBase<Long> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@SequenceGenerator(name = "solicitacao_seq" , sequenceName = "solicitacao_seq")
	private Long id;

	@Column(name = "tipoSolicitacao")
	private TipoSolicitacaoEnum tipo;

	@JoinColumn(name = "id_imovel")
	@ManyToOne(fetch = FetchType.LAZY)
	private Imovel imovel;

	public TipoSolicitacaoEnum getTipo() {
		return tipo;
	}

	public void setTipo(TipoSolicitacaoEnum tipo) {
		this.tipo = tipo;
	}

	@Override
	public String toString() {
		return "Solicitacao [tipo=" + tipo + "]";
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Imovel getImovel() {
		return imovel;
	}

	public void setImovel(Imovel imovel) {
		this.imovel = imovel;
	}
	
	

}
