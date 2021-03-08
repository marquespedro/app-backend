package br.com.app.service;

import java.util.Collection;
import java.util.Objects;

import javax.ejb.Stateless;
import javax.inject.Inject;

import br.com.app.dto.ContaDTO;
import br.com.app.exception.AppException;
import br.com.app.exception.mensagens.MensagemErro;
import br.com.app.model.Conta;
import br.com.app.persistence.ContaPersistence;

@Stateless
public class ContaService extends ServiceBase<Conta, Long , ContaDTO> {

	@Inject
	private ContaPersistence persistence;

	public Collection<Conta> salvar(Collection<Conta> contas) {
				
		for (Conta c : contas) {
			salvar(c);
		}
		
		return contas;
	}

	public Conta salvar(Conta conta) {
		
		validarContaJaCadastrada(conta.getAgencia(), conta.getNumero());
			
		return persistence.persistir(conta);
	}


	public Conta validarContaJaCadastrada(String agencia, String numero) {
		
		Conta encontrado = persistence.obterPorAgenciaNumeroConta(agencia, numero);	
		
		if(Objects.isNull(encontrado)) {
			throw new AppException(new MensagemErro("ja.existe.registro" , "Agencia : " + agencia + " Conta Numero : "+  numero));
		}
		
		return encontrado;
	}

}
