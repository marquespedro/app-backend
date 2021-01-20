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

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "endereco")
@NamedQuery(name="Endereco.findByCep", query="SELECT e FROM Endereco e where e.cep =:pCep")
@Data
@EqualsAndHashCode(callSuper = false, exclude = {"id"})
@NoArgsConstructor
@AllArgsConstructor
public class Endereco extends EntidadeBase<Long>{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE , generator = "endereco_seq")
	@SequenceGenerator(name = "endereco_seq" , sequenceName = "endereco_seq")
	private Long id;
	
	@Column(name = "cep")
	@NotBlank(message = "cep nao pode ser vazio")
	private String cep;

	@Column(name = "bairro")
	@NotBlank(message = "bairro nao pode ser vazio")
	private String bairro;

	@Column(name = "numero")
	@NotBlank(message = "numero nao pode ser vazio")
	private String numero;

	@Column(name = "complemento")
	private String complemento;

		
}
