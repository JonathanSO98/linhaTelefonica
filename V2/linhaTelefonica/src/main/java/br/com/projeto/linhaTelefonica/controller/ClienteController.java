package br.com.projeto.linhaTelefonica.controller;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.com.projeto.linhaTelefonica.entities.Cliente;
import br.com.projeto.linhaTelefonica.responses.Response;
import br.com.projeto.linhaTelefonica.services.ClienteServices;

@RestController
@RequestMapping("/clientes")
public class ClienteController {
	@Autowired
	private ClienteServices clienteService;

	@PostMapping(path = "/cadastrar")
	public ResponseEntity<Response<Cliente>> cadastrar(@Valid @RequestBody Cliente cliente,
			BindingResult result) {
		Response<Cliente> response = new Response<Cliente>();

		if (result.hasErrors()) {
			result.getAllErrors().forEach(error -> response.getErrors().add(error.getDefaultMessage()));
			return ResponseEntity.badRequest().body(response);
		}

		Cliente clienteSalvar = this.clienteService.salvar(cliente);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id_cliente}")
				.buildAndExpand(cliente.getIdCliente()).toUri();
		response.setData(clienteSalvar);
		return ResponseEntity.created(location).body(response);
	}

	@GetMapping
	public ResponseEntity<List<Cliente>> listar() {
		List<Cliente> clientes = clienteService.listar();
		return ResponseEntity.status(HttpStatus.OK).body(clientes);
	}

	@GetMapping(path = "/{id_cliente}")
	public ResponseEntity<Response<Cliente>> buscar(@PathVariable("id_cliente") Long idCliente) throws Exception {

		Cliente cliente = clienteService.buscar(idCliente);
		Response<Cliente> response = new Response<Cliente>();
		response.setData(cliente);
		return ResponseEntity.status(HttpStatus.OK).body(response);
	}
}
