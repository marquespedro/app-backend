package br.com.app.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false , of = {"cpf"})
@Builder
public class PessoaFisica extends EntidadeBase<Long>{

	private static final long serialVersionUID = 1L;

	@Id
	private Long id;

	@NotBlank
	private String nome;
	
	@NotBlank
	private String cpf;
	
	@JoinColumn(name = "id_endereco")
	@OneToOne
	@NotNull
	private Endereco endereco;

	@Override
	public Long getId() {
		return id;
	}
}
