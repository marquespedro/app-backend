package br.com.app.resources;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import br.com.app.dto.ClienteDTO;
import br.com.app.model.Cliente;
import br.com.app.service.ClienteService;

@Consumes(value = MediaType.APPLICATION_JSON)
@Produces(value = MediaType.APPLICATION_JSON)
@Path(value = "/cliente")
public class ClienteResource {
	 
	@Inject
	private ClienteService service;

	
	@POST
	public ClienteDTO salvar(ClienteDTO clienteDTO) {
				
		Cliente cliente = service.converter(clienteDTO, Cliente.class);
				
		return service.converter(cliente, ClienteDTO.class);
	}
	
}
