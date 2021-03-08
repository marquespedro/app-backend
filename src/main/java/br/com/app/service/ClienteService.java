package br.com.app.service;

import javax.ejb.Stateless;
import javax.inject.Inject;

import br.com.app.dto.ClienteDTO;
import br.com.app.model.Cliente;
import br.com.app.persistence.ClientePersistence;

@Stateless
public class ClienteService extends ServiceBase<Cliente, Long , ClienteDTO> {

	@Inject
	private ClientePersistence persistence;

	@Inject
	private PessoaFisicaService pessoaService;

	@Inject
	private ContaService contaService;
	

	public Cliente salvar(Cliente cliente) {
				
		pessoaService.salvar(cliente.getPessoaFisica());

		contaService.salvar(cliente.getContas());
	
		return persistence.persistir(cliente);
		
	}
	
}
