package br.com.app.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;




@Entity
@Table(name = "proprietario")
@NamedQuery(name="Proprietario.findByCpf", query="SELECT p FROM Proprietario p where p.cpf =:pCpf")
public class Proprietario extends EntidadeBase<Long> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	@SequenceGenerator(name = "proprietario_seq" , sequenceName = "proprietario_seq")
	private Long id;
	
	@Column(name = "nome")
	@NotBlank
	private String nome;
	
	@Column(name = "cpf")
	@NotBlank
	private String cpf;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	
	
}
