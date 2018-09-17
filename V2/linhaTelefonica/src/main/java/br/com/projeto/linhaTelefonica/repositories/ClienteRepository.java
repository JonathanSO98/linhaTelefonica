package br.com.projeto.linhaTelefonica.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.projeto.linhaTelefonica.entities.Cliente;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long> {
	List<Cliente> findByNomeCliente(String nomeCliente);

	List<Cliente> findByEmailCliente(String emailCliente);

	List<Cliente> findByNumLinhaCliente(String numLinhaCliente);
}
