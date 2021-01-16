package br.com.app.exception.handle;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.ResponseBuilder;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import br.com.app.exception.AppException;
import br.com.app.exception.bundle.AppI18N;

@Provider
public class AppExceptionHandle implements ExceptionMapper<AppException>{

    @Context
    private HttpServletRequest request;

    @Context
    private HttpServletResponse response;
	
    @Inject
    private AppI18N appI18N;
	
	@Override
	public Response toResponse(AppException exception) {
		
		appI18N.tratarMensagens(request.getLocale(), exception);
		
        ResponseBuilder resp = Response.status(Status.BAD_REQUEST)
        								.entity(AppExceptionResponse.build(exception))
        								.type(MediaType.APPLICATION_JSON);
		
		return resp.build();
	}

}
