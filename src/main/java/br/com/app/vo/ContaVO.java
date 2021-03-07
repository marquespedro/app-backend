package br.com.app.vo;

import br.com.app.model.enumerator.TipoConta;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;


@Data
@Builder
@EqualsAndHashCode(callSuper = false)
public class ContaVO extends BaseVO {

	private Long id;

	private String agencia;

	private String numero;

	private TipoConta tipo;
}
