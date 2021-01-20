package br.com.app.model.enumerator;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Converter(autoApply = true)
public class SituacaoProcessoEnumConverter implements AttributeConverter<Integer, SituacaoProcessoEnum> {

	@Override
	public SituacaoProcessoEnum convertToDatabaseColumn(Integer attribute) {
		return SituacaoProcessoEnum.comoEnum(attribute);
	}

	@Override
	public Integer convertToEntityAttribute(SituacaoProcessoEnum dbData) {
		return dbData.getCodigo();
	}

}
