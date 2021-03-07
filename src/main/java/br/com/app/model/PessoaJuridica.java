package br.com.app.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false , of = {"cnpj"})
public class PessoaJuridica extends EntidadeBase<Long>{

	private static final long serialVersionUID = 1L;

	@Id
	private Long id;

	private String cnpj;
	
	@JoinColumn(name = "id_endereco")
	@OneToOne
	private Endereco endereco;
	
	@Override
	public Long getId() {
		return id;
	}
}
