package br.com.projeto.linhaTelefonica.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.projeto.linhaTelefonica.entities.Cliente;
import br.com.projeto.linhaTelefonica.entities.Cliente;
import br.com.projeto.linhaTelefonica.repositories.ClienteRepository;

@Service
public class ClienteServices {

	@Autowired
	private ClienteRepository clienteRepository;

	public List<Cliente> listar() {
		return clienteRepository.findAll();
	}

	public Cliente salvar(Cliente cliente) {

		return clienteRepository.save(cliente);
	}

	public Cliente buscar(Long idCliente) throws Exception {
		Cliente cliente = clienteRepository.findOne(idCliente);

		if (cliente == null) {
			throw new Exception("Cliente não cadastrado");
		}
		return cliente;
	}
	
	public void excluir(Long idCliente) {
		Cliente cliente = clienteRepository.findOne(idCliente);
		System.out.println("Removendo o cliente: " + cliente.getNomeCliente());
		clienteRepository.delete(cliente);
	}
	
	public Cliente alterar(Cliente cliente) throws Exception {
		clienteRepository.save(cliente);
		return cliente;
	}
}
