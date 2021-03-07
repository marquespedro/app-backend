package br.com.app.persistence;

import java.util.Objects;

import javax.ejb.Stateless;

import br.com.app.model.PessoaFisica;

@Stateless
public class PessoaFisicaPersistence extends PersistenceBase<PessoaFisica, Long> {

	
	public PessoaFisica salvar(PessoaFisica pessoa) {
	
		if(Objects.isNull(pessoa)) {
			return null;
		}
		
		return persistir(pessoa);
	} 
}
