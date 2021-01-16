package br.com.app.exception.bundle;

import java.text.MessageFormat;
import java.util.List;
import java.util.Locale;
import java.util.MissingResourceException;
import java.util.ResourceBundle;

import javax.ejb.Singleton;

import br.com.app.exception.AppException;
import br.com.app.exception.Mensagem;



@Singleton
public class AppI18N {

	
	public void tratarMensagens(Locale locale, AppException exception) {
		montarMensagens(exception.getMensagens(), obterBundle(locale));
	}
	
	public ResourceBundle obterBundle(Locale locale) {
		
		ResourceBundle bundle = null;
	
		try {
			bundle = ResourceBundle.getBundle("messages", locale, Thread.currentThread().getContextClassLoader());
		} catch (MissingResourceException e) {
			System.out.println("bundle com nome messages nao encontrado ...");
		}
		
		return bundle;
	}
	
	
    private void montarMensagens(List<Mensagem> mensagens, ResourceBundle bundle) {
		for (Mensagem mensagem : mensagens) {
			try {
				montarMensagem(bundle, mensagem);
			} catch (MissingResourceException e) {
				System.out.println("mensagem nao encontrada no bundle...");
			}
		}
    }
    
    private void montarMensagem(ResourceBundle bundle, Mensagem mensagem) {
        String valor = bundle.getString(mensagem.getMensagem());
        mensagem.setMensagem(MessageFormat.format(valor, (Object[]) mensagem.getParametros()));
    }
    
}
