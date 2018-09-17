package br.com.projeto.linhaTelefonica.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.projeto.linhaTelefonica.entities.Plano;
import br.com.projeto.linhaTelefonica.repositories.PlanoRepository;

@Service
public class PlanoServices {

	@Autowired
	private PlanoRepository planoRepository;

	public List<Plano> listar() {
		return planoRepository.findAll();
	}

	public Plano salvar(Plano plano) {

		return planoRepository.save(plano);
	}

	public Plano buscar(Long idPlano) throws Exception {
		Plano plano = planoRepository.findOne(idPlano);

		if (plano == null) {
			throw new Exception("Plano não cadastrado");
		}
		return plano;
	}

	public void excluir(Long idPlano) {
		Plano plano = planoRepository.findOne(idPlano);
		planoRepository.delete(plano);
	}

	public Plano alterar(Plano plano) throws Exception {
		planoRepository.save(plano);
		return plano;
	}

}
