package br.com.projeto.linhaTelefonica.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import br.com.projeto.linhaTelefonica.entities.Plano;

@Repository
public interface PlanoRepository extends JpaRepository<Plano, Long> {

}
