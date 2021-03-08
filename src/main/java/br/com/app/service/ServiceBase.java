package br.com.app.service;

import java.io.Serializable;
import java.util.Objects;

import org.modelmapper.ModelMapper;

import br.com.app.dto.BaseDTO;
import br.com.app.model.EntidadeBase;

public class ServiceBase<T extends EntidadeBase<K>, K extends Serializable , Z extends BaseDTO> {

	private ModelMapper mapper;

	public ServiceBase() {
		this.mapper = new ModelMapper();
	}

	public Z converter(T entidade,  Class<Z> clazz) {

		if (Objects.isNull(entidade) || Objects.isNull(clazz)) {
			return null;
		}

		return mapper.map(entidade, clazz);
	}

	public T  converter(Z  dto, Class<T> clazz) {

		if (Objects.isNull(dto) || Objects.isNull(clazz)) {
			return null;
		}
		
		return mapper.map(dto, clazz);
	
	}
	
	
}
