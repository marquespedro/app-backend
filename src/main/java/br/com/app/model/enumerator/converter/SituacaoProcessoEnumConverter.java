package br.com.app.model.enumerator.converter;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

import br.com.app.model.enumerator.SituacaoProcessoEnum;

@Converter(autoApply = true)
public class SituacaoProcessoEnumConverter implements AttributeConverter<SituacaoProcessoEnum , Integer> {

	@Override
	public Integer convertToDatabaseColumn(SituacaoProcessoEnum attribute) {
		return attribute.getCodigo();
	}

	@Override
	public SituacaoProcessoEnum convertToEntityAttribute(Integer dbData) {
		return SituacaoProcessoEnum.comoEnum(dbData);
	}


}
