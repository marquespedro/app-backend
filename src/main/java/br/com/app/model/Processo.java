package br.com.app.model;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import br.com.app.model.enumerator.SituacaoProcessoEnum;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;




@Entity
@Table(name = "processo")
@Data
@EqualsAndHashCode(callSuper = false)
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Processo extends EntidadeBase<Long> {


	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE , generator = "processo_seq")
	@SequenceGenerator(name = "processo_seq" , sequenceName = "processo_seq")
	private Long id;

	@Column(name = "situacao")
	private SituacaoProcessoEnum situacao;
	
	@Column(name = "data_criacao")
	private LocalDateTime dataCriacao;
	
	@Column(name = "data_finalizacao")
	private LocalDateTime dataFinalizacao;

	@Column(name = "descricao")
	private String descricao;

	@Override
	public Long getId() {
		return id;
	}
	
}
