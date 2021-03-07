package br.com.app.model;

import java.util.Collection;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import org.hibernate.validator.constraints.UniqueElements;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "cliente")
@Data
@EqualsAndHashCode(callSuper = false)
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Cliente extends EntidadeBase<Long> {


	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE , generator = "imovel_seq")
	@SequenceGenerator(name = "imovel_seq" , sequenceName = "imovel_seq")
	private Long id;
	
	@UniqueElements
	@JoinColumn(name = "id_conta")
	@JoinTable(name = "contas_cliente", 
	   joinColumns = @JoinColumn(name = "id_cliente", referencedColumnName = "id"),
	   inverseJoinColumns = @JoinColumn(name = "id_conta", referencedColumnName = "id"),
	   uniqueConstraints = @UniqueConstraint(name = "unique_conta_cliente", columnNames = {"id_cliente", "id_conta" }))
	@OneToMany(fetch = FetchType.LAZY)
	private Set<Conta> contas;

	@JoinColumn(name = "id_pessoa_fisica")
	@OneToOne(fetch = FetchType.LAZY)
	private PessoaFisica pessoaFisica;
	
	@JoinColumn(name = "id_pessoa_juridica")
	@OneToOne(fetch = FetchType.LAZY)
	private PessoaJuridica pessoaJuridica;
	
	public void adicionarContas(Collection<Conta> contas) {
		
		if(Objects.isNull(this.contas) || this.contas.isEmpty()) {
			this.contas = new HashSet<>();
			this.contas.addAll(contas);
			return;
		}
		
		this.contas.addAll(contas);
	}
	
	@Override
	public Long getId() {
		return id;
	}
	
}
