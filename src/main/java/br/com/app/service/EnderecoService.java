package br.com.app.service;

import java.util.Objects;

import javax.ejb.Stateless;
import javax.inject.Inject;

import org.apache.commons.lang3.StringUtils;

import br.com.app.dto.EnderecoDTO;
import br.com.app.exception.AppException;
import br.com.app.exception.mensagens.MensagemErro;
import br.com.app.model.Endereco;
import br.com.app.persistence.EnderecoPersistence;

@Stateless
public class EnderecoService extends ServiceBase<Endereco, Long , EnderecoDTO> {

	@Inject
	private EnderecoPersistence persistence;

	public Endereco salvar(Endereco endereco) {

		Endereco enderecoEncontrado = obterEnderecoPorCep(endereco.getCep());

		if (Objects.nonNull(enderecoEncontrado)) {
			return enderecoEncontrado;
		}

		return persistence.salvar(endereco);
	}

	public Endereco atualizar(Endereco endereco) {

		Endereco enderecoValido = validar(endereco);
				
		return persistence.salvar(enderecoValido);
	}

	public Endereco obterEnderecoPorCep(String cep) {

		if (StringUtils.isEmpty(cep)) {
			return null;
		}

		return persistence.obterPorCep(cep);

	}

	public Endereco validar(Endereco endereco) {

		Endereco encontrado = persistence.find(Endereco.class, endereco.getId());

		if (Objects.isNull(encontrado)) {
			throw new AppException(new MensagemErro("registro.nao.encontrado", endereco.getId().toString()));
		}

		return encontrado;
	}

	
}
