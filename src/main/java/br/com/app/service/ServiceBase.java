package br.com.app.service;

import java.io.Serializable;

import org.apache.commons.beanutils.BeanUtils;

import br.com.app.exception.AppException;
import br.com.app.exception.mensagens.MensagemErro;
import br.com.app.model.EntidadeBase;

public class ServiceBase<T extends EntidadeBase<K>, K extends Serializable> {

	public void copiarPropriedades(T destino, T origem) {
		
		try {
		
			BeanUtils.copyProperties(destino, origem);
		
		} catch (Exception e) {
			
			e.printStackTrace();
			
			throw new AppException(new MensagemErro("erro.generico" , e.getMessage()));
		}
	}
	
}
