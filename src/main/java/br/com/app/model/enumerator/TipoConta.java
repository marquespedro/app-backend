package br.com.app.model.enumerator;

import java.util.stream.Stream;

import lombok.Getter;

@Getter
public enum TipoConta {
	
	CORRENTE(1 , "Corrente"),
	POUPANCA(2 , "Poupança"),
	SALARIO(3 , "Salario");
	
	private Integer codigo;

	private String descricao;
	
	private TipoConta(Integer codigo, String descricao) {
		this.codigo = codigo;
		this.descricao = descricao;
	}

	public static TipoConta comoEnum(Integer dbData) {
		return Stream.of(TipoConta.values()).filter(c -> c.getCodigo().equals(dbData)).findFirst().orElse(null);
	}

}
