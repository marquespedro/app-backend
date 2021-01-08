package br.com.app.resources;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import br.com.app.model.Solicitacao;
import br.com.app.service.SolicitacaoService;

@Consumes(value = MediaType.APPLICATION_JSON)
@Produces(value = MediaType.APPLICATION_JSON)
@Path(value = "/solicitacao")
public class SolicitacaoResource {
	
	@Inject
	private SolicitacaoService service;
	
	@POST
	public Solicitacao criar(Solicitacao solicitacao) {
		return service.criar(solicitacao);
	}
	
}
