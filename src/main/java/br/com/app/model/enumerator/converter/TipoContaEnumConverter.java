package br.com.app.model.enumerator.converter;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

import br.com.app.model.enumerator.TipoConta;

@Converter(autoApply = true)
public class TipoContaEnumConverter implements AttributeConverter<TipoConta , Integer> {

	@Override
	public Integer convertToDatabaseColumn(TipoConta attribute) {
		return attribute.getCodigo();
	}

	@Override
	public TipoConta convertToEntityAttribute(Integer dbData) {
		return TipoConta.comoEnum(dbData);
	}


}
