package br.com.app.service;

import java.util.Objects;

import javax.ejb.Stateless;
import javax.inject.Inject;

import org.apache.commons.lang3.StringUtils;

import br.com.app.exception.AppException;
import br.com.app.exception.mensagens.MensagemErro;
import br.com.app.model.Endereco;
import br.com.app.persistence.EnderecoPersistence;

@Stateless
public class EnderecoService {

	@Inject
	private EnderecoPersistence persistence;

	public Endereco salvar(Endereco endereco) {

		validar(endereco);

		Endereco enderecoEncontrado = obterEnderecoPorCep(endereco.getCep());

		if (Objects.nonNull(enderecoEncontrado)) {
			return enderecoEncontrado;	
		}
		
		return persistence.salvar(endereco);
	}

	public Endereco obterEnderecoPorCep(String cep) {

		if (StringUtils.isEmpty(cep)) {
			return null;
		}
		
		return persistence.obterPorCep(cep);

	}

	private void validar(Endereco endereco) {

		if (StringUtils.isEmpty(endereco.getCep()) || StringUtils.isEmpty(endereco.getBairro())
				|| StringUtils.isEmpty(endereco.getNumero())) {
			throw new AppException(new MensagemErro("campos.obrigatorios.nao.preenchidos", "cep, bairro, numero"));
		}

	}

}
