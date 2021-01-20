package br.com.app.exception.handle;

import java.util.Arrays;
import java.util.List;

import br.com.app.exception.AppException;
import br.com.app.exception.mensagens.Mensagem;



public class AppExceptionResponse {


    private List<Mensagem> mensagens;

    private AppExceptionResponse(Mensagem erro) {

        mensagens = Arrays.asList(erro);
    }

    private AppExceptionResponse(AppException exeception) {
        mensagens = exeception.getMensagens();
    }

    public List<Mensagem> getMensagens() {

        return mensagens;
    }

    public static AppExceptionResponse build(AppException exeception) {

        return new AppExceptionResponse(exeception);
    }

    public static AppExceptionResponse build(Mensagem erro) {

        return new AppExceptionResponse(erro);
    }

}
