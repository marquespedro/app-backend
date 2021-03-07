package br.com.app.vo;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@Builder
@EqualsAndHashCode
public class EnderecoVO {

	private Long id;

	private String cep;

	private String bairro;

	private String numero;

	private String complemento;
}
