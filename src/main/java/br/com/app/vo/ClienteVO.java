package br.com.app.vo;

import java.util.Collection;

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
public class ClienteVO extends BaseVO {

	private Long id;
	
	private Collection<ContaVO> contas;

	private PessoaFisicaVO pessoaFisica;
	
	private PessoaJuridicaVO pessoaJuridica;

}
