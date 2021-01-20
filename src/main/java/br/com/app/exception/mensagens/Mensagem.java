package br.com.app.exception.mensagens;


public  abstract class Mensagem {

    private String mensagem;
    private String[] parametros;
	
    public Mensagem(String mensagem , String [] parametros) {
    	this.mensagem = mensagem;
    	this.parametros = parametros;
    }
    
    public String getMensagem() {
		return mensagem;
	}
	
    public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	}

	public String[] getParametros() {
		return parametros;
	}
	
	public void setParametros(String[] parametro) {
		this.parametros = parametro;
	}

     
}
