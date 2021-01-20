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
@Table(name = "proprietario")
@NamedQuery(name="Proprietario.findByCpf", query="SELECT p FROM Proprietario p where p.cpf =:pCpf")
@Data
@EqualsAndHashCode(callSuper = false, of = {"cpf"})
@AllArgsConstructor
@NoArgsConstructor
public class Proprietario extends EntidadeBase<Long> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE , generator = "proprietario_seq")
	@SequenceGenerator(name = "proprietario_seq" , sequenceName = "proprietario_seq")
	private Long id;
	
	@Column(name = "nome")
	@NotBlank
	private String nome;
	
	@Column(name = "cpf")
	@NotBlank
	private String cpf;


	
	
}
