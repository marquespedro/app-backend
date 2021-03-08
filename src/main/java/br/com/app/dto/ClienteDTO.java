package br.com.app.dto;

import java.util.Collection;

import javax.json.bind.annotation.JsonbTransient;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@Builder
@EqualsAndHashCode(callSuper = false)
@AllArgsConstructor
@NoArgsConstructor
public class ClienteDTO extends BaseDTO {


	private static final long serialVersionUID = 1L;

	private Long id;
	
	@JsonbTransient
	private Collection<ContaDTO> contas;
	private PessoaFisicaDTO pessoaFisica;
	private PessoaJuridicaDTO pessoaJuridica;

}
