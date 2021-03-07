package br.com.app.service;

import javax.ejb.Stateless;
import javax.inject.Inject;

import br.com.app.model.PessoaFisica;
import br.com.app.persistence.PessoaFisicaPersistence;

@Stateless
public class PessoaService extends ServiceBase<PessoaFisica, Long> {

	@Inject
	private PessoaFisicaPersistence persistence;
	
	@Inject
	private EnderecoService enderecoService;
	
	public PessoaFisica salvar(PessoaFisica pessoa) {
		
		enderecoService.salvar(pessoa.getEndereco());
		
		return persistence.persistir(pessoa);
	}
	
}
