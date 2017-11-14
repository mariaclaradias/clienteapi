package com.clientes.resources;

import java.net.URI;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.clientes.domain.Cliente;
import com.clientes.domain.Endereco;
import com.clientes.services.ClientesService;

@Controller
@RestController
@RequestMapping("/clientes")
public class ClientesResources {
	
	@Autowired
	private ClientesService clientesService;
	
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<Cliente>> list() {
		return ResponseEntity.status(HttpStatus.OK).body(clientesService.list());
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Void> save(@RequestBody Cliente cliente) {
		 cliente = clientesService.salvar(cliente);
		 
		 URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
				 .path("/{id}").buildAndExpand(cliente.getId()).toUri();
		 return ResponseEntity.created(uri).build();
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<?> search(@PathVariable("id") Long id) {
		Cliente cliente = clientesService.buscar(id);
		return ResponseEntity.status(HttpStatus.OK).body(cliente);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> delete(@PathVariable("id") Long id) {
		clientesService.deletar(id);
		return ResponseEntity.noContent().build();
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Void> update(@RequestBody Cliente cliente,@PathVariable("id") Long id) {
		cliente.setId(id);
	    clientesService.atualizar(cliente);	
		return ResponseEntity.noContent().build();
	}
	
	@RequestMapping(value = "/{id}/endereco", method = RequestMethod.POST)
	public ResponseEntity<Void> adicionarEndereço(@PathVariable("id") Long clienteId, 
			@RequestBody Endereco endereco) {
		clientesService.salvarEndereco(clienteId, endereco);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().build().toUri();
		return ResponseEntity.created(uri).build();
	}
	
	@RequestMapping(value = "/{id}/endereco", method = RequestMethod.GET)
	public ResponseEntity<List<Endereco>> listarEnderecos(@PathVariable("id") Long clienteId){
		List<Endereco> enderecos = clientesService.listarEnderecos(clienteId);
		return ResponseEntity.status(HttpStatus.OK).body(enderecos);
	}
}
