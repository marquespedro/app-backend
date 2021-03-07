package br.com.app.resources;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import br.com.app.service.ClienteService;
import br.com.app.vo.ClienteVO;

@Consumes(value = MediaType.APPLICATION_JSON)
@Produces(value = MediaType.APPLICATION_JSON)
@Path(value = "/solicitacao")
public class ClienteResource {
	
	@Inject
	private ClienteService service;
	
	@POST
	public ClienteVO salvar(ClienteVO cliente) {
		
		return null;
	}
	
}
