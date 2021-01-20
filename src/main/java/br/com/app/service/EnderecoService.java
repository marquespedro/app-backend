package br.com.app.service;

import javax.ejb.Stateless;
import javax.inject.Inject;

import org.apache.commons.lang3.StringUtils;

import br.com.app.exception.AppException;
import br.com.app.exception.MensagemErro;
import br.com.app.model.Endereco;
import br.com.app.persistence.EnderecoPersistence;

@Stateless
public class EnderecoService {

	@Inject
	private EnderecoPersistence persistence;

	public Endereco salvar(Endereco endereco) {

		validar(endereco);

		return persistence.salvar(endereco);
	}

	private void validar(Endereco endereco) {

		if (StringUtils.isEmpty(endereco.getCep()) || StringUtils.isEmpty(endereco.getBairro())
				|| StringUtils.isEmpty(endereco.getNumero())) {
			throw new AppException(new MensagemErro("campos.obrigatorios.nao.preenchidos", "cep, bairro, numero"));
		}

	}

}
