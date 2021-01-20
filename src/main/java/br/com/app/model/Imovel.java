package br.com.app.model;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "imovel")
public class Imovel extends EntidadeBase<Long> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE , generator = "imovel_seq")
	@SequenceGenerator(name = "imovel_seq" , sequenceName = "imovel_seq")
	private Long id;
	
	@JoinColumn(name = "id_endereco")
	@OneToOne(fetch = FetchType.LAZY)
	private Endereco endereco;
	
	@JoinColumn(name = "id_proprietario")
	@ManyToOne(fetch = FetchType.LAZY)
	private Proprietario proprietario;

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	public Proprietario getProprietario() {
		return proprietario;
	}

	public void setProprietario(Proprietario proprietario) {
		this.proprietario = proprietario;
	}
	
	
	
}
