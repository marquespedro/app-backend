package br.com.app.model.enumerator;

import javax.persistence.AttributeConverter;
import javax.persistence.Convert;

@Convert
public class TipoSolicitacaoEnumConverter implements AttributeConverter<Integer, TipoSolicitacaoEnum> {

	@Override
	public TipoSolicitacaoEnum convertToDatabaseColumn(Integer attribute) {
		return TipoSolicitacaoEnum.comoEnum(attribute);
	}

	@Override
	public Integer convertToEntityAttribute(TipoSolicitacaoEnum dbData) {
		return dbData.getCodigo();
	}

}
