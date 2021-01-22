package br.com.app.model.enumerator.converter;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

import br.com.app.model.enumerator.TipoSolicitacaoEnum;

@Converter(autoApply = true)
public class TipoSolicitacaoEnumConverter implements AttributeConverter<TipoSolicitacaoEnum, Integer > {

	@Override
	public Integer convertToDatabaseColumn(TipoSolicitacaoEnum attribute) {
	
		return attribute.getCodigo();
	}

	@Override
	public TipoSolicitacaoEnum convertToEntityAttribute(Integer dbData) {
		
		return TipoSolicitacaoEnum.comoEnum(dbData);
	}



}
