package br.com.app.strategy.annotation;

import static java.lang.annotation.ElementType.CONSTRUCTOR;
import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.PARAMETER;
import static java.lang.annotation.ElementType.TYPE;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.inject.Qualifier;

import br.com.app.model.enumerator.TipoSolicitacaoEnum;

@Qualifier
@Retention(RetentionPolicy.RUNTIME)
@Target({ TYPE, FIELD, PARAMETER, CONSTRUCTOR })
public  @interface TipoSolicitacao {

	TipoSolicitacaoEnum tipo();
}
