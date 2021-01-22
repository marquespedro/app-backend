package br.com.app.model.enumerator;

import java.util.stream.Stream;

public enum TipoSolicitacaoEnum {

	CADASTRO_IMOVEL(1),
	ALTERAR_PROPRIETARIO(2);

	private Integer codigo;
	
	private TipoSolicitacaoEnum(Integer codigo) {
		this.codigo = codigo;
	}

	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

	public static TipoSolicitacaoEnum comoEnum(Integer codigo) {
		return Stream.of(TipoSolicitacaoEnum.values()).filter(t -> t.getCodigo().equals(codigo)).findFirst().orElse(null);
	}

	
}
