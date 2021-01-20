package br.com.app.service;

import javax.ejb.Stateless;
import javax.inject.Inject;

import br.com.app.model.Imovel;
import br.com.app.persistence.ImovelPersistence;

@Stateless
public class ImovelService {

	@Inject
	private ImovelPersistence persistence;

	@Inject
	private EnderecoService enderecoService;;

	@Inject
	private ProprietarioService proprietarioService;

	public Imovel salvar(Imovel imovel) {

		enderecoService.salvar(imovel.getEndereco());

		imovel.setProprietario(proprietarioService.salvar(imovel.getProprietario()));

		return persistence.salvar(imovel);
	}

}
