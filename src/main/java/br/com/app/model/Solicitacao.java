package br.com.app.model;

import javax.persistence.Convert;

import br.com.app.model.enumerator.TipoSolicitacaoEnum;
import br.com.app.model.enumerator.TipoSolicitacaoEnumConverter;

public class Solicitacao {

	@Convert(converter = TipoSolicitacaoEnumConverter.class)
	private TipoSolicitacaoEnum tipo;

	private String descricao;
	
	public TipoSolicitacaoEnum getTipo() {
		return tipo;
	}
	public void setTipo(TipoSolicitacaoEnum tipo) {
		this.tipo = tipo;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	@Override
	public String toString() {
		return "Solicitacao [tipo=" + tipo + ", descricao=" + descricao + "]";
	}

	
	
}
