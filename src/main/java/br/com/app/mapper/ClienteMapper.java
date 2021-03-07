package br.com.app.mapper;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import br.com.app.model.Cliente;
import br.com.app.vo.ClienteVO;

@Mapper
public interface ClienteMapper {

	ClienteMapper INSTANCE  = Mappers.getMapper(ClienteMapper.class);
 
	Cliente converterParaEntidade(ClienteVO vo);
	 
	@InheritInverseConfiguration
	ClienteVO converterParaVO(Cliente cliente);
}
