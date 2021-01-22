package br.com.app.service;

import java.util.Objects;

import javax.ejb.Stateless;
import javax.inject.Inject;

import br.com.app.exception.AppException;
import br.com.app.exception.mensagens.MensagemErro;
import br.com.app.model.Imovel;
import br.com.app.model.Proprietario;
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
	
		imovel.setEndereco(enderecoService.salvar(imovel.getEndereco()));

		imovel.setProprietario(proprietarioService.salvar(imovel.getProprietario()));

		return persistence.persistir(imovel);
	}
	

	public Imovel atualizar(Imovel imovel) {
	
		Imovel imovelSalvo = validar(imovel);

		if(imovel.equals(imovelSalvo)) {
			return imovelSalvo;
		}
		
		imovelSalvo.setProprietario(proprietarioService.atualizar(imovel.getProprietario()));
		
		imovelSalvo.setEndereco(enderecoService.atualizar(imovel.getEndereco()));
			
		return persistence.persistir(imovelSalvo);
	}

	public Imovel atribuirProprietario(Imovel imovel, Long idProprietario) {
		
		Imovel imovelValido = validar(imovel);
		
		Proprietario proprietarioValido = proprietarioService.validar(idProprietario);
		
		imovelValido.adicionarProprietario(proprietarioValido);
			
		return persistence.persistir(imovelValido);
	}
	
	public Imovel validar(Imovel imovel) {
		
		Imovel encontrado = persistence.find(Imovel.class, imovel.getId());
				
		if(Objects.isNull(encontrado)) {
			throw new AppException(new MensagemErro("registro.nao.encontrado" , imovel.getId().toString()));
		}
			
		return encontrado;
	}

}
