package br.com.app.service;

import javax.ejb.Stateless;
import javax.inject.Inject;

import br.com.app.mapper.ClienteMapper;
import br.com.app.model.Cliente;
import br.com.app.persistence.ClientePersistence;
import br.com.app.vo.ClienteVO;

@Stateless
public class ClienteService extends ServiceBase<Cliente, Long> {

	@Inject
	private ClientePersistence persistence;

	@Inject
	private PessoaService pessoaService;

	@Inject
	private ContaService contaService;

	public ClienteVO salvar(ClienteVO clienteVO) {

		Cliente cliente = ClienteMapper.INSTANCE.converterParaEntidade(clienteVO);
		
		pessoaService.salvar(cliente.getPessoaFisica());

		contaService.salvar(cliente.getContas());
	
		persistence.persistir(cliente);
				
		return ClienteMapper.INSTANCE.converterParaVO(cliente);
		
	}
	
}
