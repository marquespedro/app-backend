package br.com.app.vo;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public class PessoaVO  extends BaseVO{

	private Long id;
	private EnderecoVO endereco;
}
