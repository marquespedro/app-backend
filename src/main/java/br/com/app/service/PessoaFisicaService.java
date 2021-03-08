package br.com.app.service;

import javax.ejb.Stateless;
import javax.inject.Inject;

import br.com.app.dto.PessoaFisicaDTO;
import br.com.app.model.PessoaFisica;
import br.com.app.persistence.PessoaFisicaPersistence;

@Stateless
public class PessoaFisicaService extends ServiceBase<PessoaFisica, Long , PessoaFisicaDTO> {

	@Inject
	private PessoaFisicaPersistence persistence;
	
	@Inject
	private EnderecoService enderecoService;
	
	public PessoaFisica salvar(PessoaFisica pessoa) {
		
		enderecoService.salvar(pessoa.getEndereco());
		
		return persistence.persistir(pessoa);
	}
	
}
