package br.com.app.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class PessoaFisicaDTO extends BaseDTO {

	private static final long serialVersionUID = 1L;

	private Long id;
	private String nome;
	private String cpf;
	private EnderecoDTO endereco;

}
