package br.com.app.resources;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import br.com.app.dto.EnderecoDTO;
import br.com.app.dto.PaginacaoDTO;
import br.com.app.service.EnderecoService;

@Consumes(value = MediaType.APPLICATION_JSON)
@Produces(value = MediaType.APPLICATION_JSON)
@Path(value = "/endereco")
public class EnderecoResource {

	@Inject
	private EnderecoService service;
	
	@GET
	@Path("/cadastrados")
	public Response consultaCadastrados(PaginacaoDTO<EnderecoDTO> dto) {
		return Response.ok(service.consultarPaginado(dto)).build();
	}
}
