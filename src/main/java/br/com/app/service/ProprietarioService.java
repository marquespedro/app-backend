package br.com.app.service;

import java.util.Objects;

import javax.ejb.Stateless;
import javax.inject.Inject;

import org.apache.commons.lang3.StringUtils;

import br.com.app.exception.AppException;
import br.com.app.exception.mensagens.MensagemErro;
import br.com.app.model.Proprietario;
import br.com.app.persistence.ProprietarioPersistence;

@Stateless
public class ProprietarioService {

	@Inject
	private ProprietarioPersistence persistence;

	public Proprietario salvar(Proprietario proprietario) {

		Proprietario encontrado = obterPorCpf(proprietario.getCpf());

		if (Objects.isNull(encontrado)) {
			return persistence.salvar(proprietario);
		}

		return encontrado;
	}

	public Proprietario obterPorCpf(String cpf) {
		
		if(StringUtils.isEmpty(cpf)) {
			
			throw new AppException(new MensagemErro("Campos obrigatorios nao preenchidos" , "cpf"));
		}
	
		return persistence.obterPorCpf(cpf);
			
	}

}
