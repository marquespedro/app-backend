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

import br.com.app.model.enumerator.TipoConta;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;




@Entity
@Table(name = "conta")
@NamedQuery(name="Conta.PorAgenciaNumeroConta", query="SELECT p FROM Conta p where p.agencia =:pAgencia and p.numero=:pNumeroConta")
@Data
@EqualsAndHashCode(callSuper = false, of = {"agencia" , "numero"})
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Conta extends EntidadeBase<Long> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE , generator = "conta_seq")
	@SequenceGenerator(name = "conta_seq" , sequenceName = "conta_seq")
	private Long id;
		
	@Column(name = "agencia")
	@NotBlank
	private String agencia;

	@Column(name = "numero")
	@NotBlank
	private String numero;

	@Column(name = "tipo")
	@NotBlank
	private TipoConta tipo;

	@Override
	public Long getId() {
		return id;
	}
}
