package br.com.app.model.enumerator;

import java.util.stream.Stream;

public enum TipoSolicitacaoEnum {

	CADASTRO_PESSOA_FISICA(1),
	CADASTRO_PESSOA_JURIDICA(2);

	private Integer codigo;
	
	private TipoSolicitacaoEnum(Integer codigo) {
		this.codigo = codigo;
	}

	public Integer getCodigo() {
		return codigo;
	}

	public static TipoSolicitacaoEnum comoEnum(Integer codigo) {
		return Stream.of(TipoSolicitacaoEnum.values()).filter(t -> t.getCodigo().equals(codigo)).findFirst().orElse(null);
	}

	
}
