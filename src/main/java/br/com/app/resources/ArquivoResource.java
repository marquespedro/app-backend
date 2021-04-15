package br.com.app.resources;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import javax.enterprise.concurrent.ManagedThreadFactory;
import javax.inject.Inject;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.container.AsyncResponse;
import javax.ws.rs.container.Suspended;
import javax.ws.rs.container.TimeoutHandler;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.jboss.resteasy.plugins.providers.multipart.InputPart;
import org.jboss.resteasy.plugins.providers.multipart.MultipartFormDataInput;

import br.com.app.service.ArquivoService;

@Path(value = "/arquivo")
public class ArquivoResource {

	//(lookup = "java:comp/DefaultManagedThreadFactory")

	
	@Inject
	private ArquivoService arquivoService;

	@POST
	@Path("/upload")
	@Consumes(MediaType.MULTIPART_FORM_DATA)
	public Response uploadFile(MultipartFormDataInput input) throws IOException {

		Map<String, List<InputPart>> uploadForm = input.getFormDataMap();

		List<InputPart> inputParts = uploadForm.get("file");

		arquivoService.criarArquivos(inputParts);

		return Response.status(Status.OK).build();
	}

	@GET
	@Path("/numeroRandom")
	public void downloadFileBase64(@Suspended AsyncResponse asyncResponse,
			@PathParam(value = "nomeArquivo") String nomeArquivo) throws NamingException {

		  ManagedThreadFactory threadFactory = (ManagedThreadFactory) new InitialContext()
			        .lookup("java:comp/DefaultManagedThreadFactory");
		
		    ExecutorService executorService = Executors.newSingleThreadExecutor(threadFactory);
		
		    executorService.submit(new Runnable() {		
			@Override
			public void run() {
				
				int resultado = arquivoService.operacaoDemorada(Integer.MAX_VALUE);
				
				asyncResponse.resume(resultado);
				
			}
		});
		
	    asyncResponse.setTimeoutHandler(new TimeoutHandler() {
	        @Override
	        public void handleTimeout(AsyncResponse ar) {
	          //Paramos com a tentariva de encontrar o número primo
	        	executorService.shutdownNow();
	          //Criamos a resposta para o cliente informando para tentar um número menor
	          Response response = Response.status(Response.Status.SERVICE_UNAVAILABLE)
	        		  .header("Error", "Operation timed out, try to get a smaller prime number")
	        		  .build();
	          //Enviamos a resposta para o cliente
	          ar.resume(response);
	        }
	    });
	    
	    asyncResponse.setTimeout(4000, TimeUnit.MILLISECONDS);
		
	}
}