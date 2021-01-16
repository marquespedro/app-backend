package br.com.app.exception;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.ApplicationException;



@ApplicationException(rollback = true)
public class AppException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private final List<Mensagem> mensagens = new ArrayList<>();

	public AppException (String mensagem) {
		super(mensagem);
	}
	
	public AppException (Mensagem mensagem) {
		this.mensagens.add(mensagem);
	}

	public List<Mensagem> getMensagens() {
		return mensagens;
	}
    
    
}
