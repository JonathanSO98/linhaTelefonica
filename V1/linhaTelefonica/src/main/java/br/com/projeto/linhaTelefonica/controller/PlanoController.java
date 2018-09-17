package br.com.projeto.linhaTelefonica.controller;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.com.projeto.linhaTelefonica.entities.Plano;
import br.com.projeto.linhaTelefonica.responses.Response;
import br.com.projeto.linhaTelefonica.services.PlanoServices;

@RestController
@RequestMapping("/planos")
public class PlanoController {

	@Autowired
	private PlanoServices planoService;

	@PostMapping(path = "/cadastrar")
	public ResponseEntity<Response<Plano>> cadastrar(@Valid @RequestBody Plano plano, BindingResult result) {
		Response<Plano> response = new Response<Plano>();

		if (result.hasErrors()) {
			result.getAllErrors().forEach(error -> response.getErrors().add(error.getDefaultMessage()));
			return ResponseEntity.badRequest().body(response);
		}

		Plano planoSalvar = this.planoService.salvar(plano);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id_plano}")
				.buildAndExpand(plano.getIdPlano()).toUri();
		response.setData(planoSalvar);
		return ResponseEntity.created(location).body(response);
	}

	@GetMapping(path = "/listar")
	public ResponseEntity<List<Plano>> listar() {
		List<Plano> planos = planoService.listar();
		return ResponseEntity.status(HttpStatus.OK).body(planos);
	}

	@GetMapping(path = "/buscar/{id_plano}")
	public ResponseEntity<Response<Plano>> buscar(@PathVariable("id_plano") Long idPlano) throws Exception {

		Plano plano = planoService.buscar(idPlano);
		Response<Plano> response = new Response<Plano>();
		response.setData(plano);
		return ResponseEntity.status(HttpStatus.OK).body(response);
	}

	@DeleteMapping(path = "/excluir/{id_plano}")
	public void excluir(@PathVariable("id_plano") Long idPlano) {
		planoService.excluir(idPlano);
	}

	@PostMapping(path = "/alterar/{id_plano}")
	public ResponseEntity<Response<Plano>> alterar(@Valid @RequestBody Plano plano,
			@PathVariable("id_plano") Long idPlano, BindingResult result) throws Exception {
		plano.setIdPlano(idPlano);
		Plano planoSalvar = this.planoService.salvar(plano);
		Response<Plano> response = new Response<Plano>();

		if (result.hasErrors()) {
			result.getAllErrors().forEach(error -> response.getErrors().add(error.getDefaultMessage()));
			return ResponseEntity.badRequest().body(response);
		}
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id_plano}")
				.buildAndExpand(plano.getIdPlano()).toUri();
		response.setData(planoSalvar);
		return ResponseEntity.created(location).body(response);
	}
}
