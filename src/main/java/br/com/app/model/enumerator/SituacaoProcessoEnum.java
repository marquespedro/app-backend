package br.com.app.model.enumerator;

import java.util.stream.Stream;

import lombok.Getter;

public enum SituacaoProcessoEnum {

	EM_ANDAMENTO(1 , "Em andamento"),
	EM_ANALISE(2 , "Em analise"),
	FINALIZADO(3 , "Finalizado");

	@Getter
	private Integer codigo;
	
	@Getter
	private String descricao;
	
	private SituacaoProcessoEnum(Integer codigo, String descricao) {
		this.codigo = codigo;
		this.descricao = descricao;
	}

	public static SituacaoProcessoEnum comoEnum(Integer codigo) {
		return Stream.of(SituacaoProcessoEnum.values()).filter(t -> t.getCodigo().equals(codigo)).findFirst().orElse(null);
	}

	
}
