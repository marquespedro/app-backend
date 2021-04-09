package br.com.app.resources;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.jboss.resteasy.plugins.providers.multipart.InputPart;
import org.jboss.resteasy.plugins.providers.multipart.MultipartFormDataInput;

import br.com.app.service.ArquivoService;

@Path(value = "/arquivo")
public class ArquivoResource {

	
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
}
