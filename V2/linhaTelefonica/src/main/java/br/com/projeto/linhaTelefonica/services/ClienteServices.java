package br.com.projeto.linhaTelefonica.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
		clienteRepository.delete(cliente);
	}

	public Cliente alterar(Cliente cliente) throws Exception {
		clienteRepository.save(cliente);
		return cliente;
	}

	public void verificar(Cliente cliente) throws Exception {
		/*
		 * Método verifica se existe Nome, Email e Número da Linha já cadastrado no banco de dados
		 */
		boolean verificar = false;
		List<Cliente> verificarCliente;
		verificarCliente = clienteRepository.findByNomeCliente(cliente.getNomeCliente());
		verificar = (verificarCliente.isEmpty()) ? true : false;
		if (verificar == true) {
			verificarCliente = clienteRepository.findByEmailCliente(cliente.getEmailCliente());
			verificar = (verificarCliente.isEmpty()) ? true : false;
		}
		if (verificar == true) {
			verificarCliente = clienteRepository.findByNumLinhaCliente(cliente.getNumLinhaCliente());
			verificar = (verificarCliente.isEmpty()) ? true : false;
		}
		if (verificar == false) {
			throw new Exception("Dados não podem se repetir");
		}
	}
}
