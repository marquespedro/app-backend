package br.com.app.model.enumerator;

import java.util.stream.Stream;

public enum SituacaoProcessoEnum {

	EM_ANDAMENTO(1 , "Em andamento"),
	EM_ANALISE(2 , "Em analise"),
	FINALIZADO(3 , "Finalizado");

	private Integer codigo;
	private String descricao;
	
	private SituacaoProcessoEnum(Integer codigo, String descricao) {
		this.codigo = codigo;
		this.descricao = descricao;
	}

	public Integer getCodigo() {
		return this.codigo;
	}

	public String getDescricao() {
		return this.descricao;
	}

	public static SituacaoProcessoEnum comoEnum(Integer codigo) {
		return Stream.of(SituacaoProcessoEnum.values()).filter(t -> t.getCodigo().equals(codigo)).findFirst().orElse(null);
	}

	
}
