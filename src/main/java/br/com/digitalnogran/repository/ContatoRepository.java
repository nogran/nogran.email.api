package br.com.digitalnogran.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.digitalnogran.model.Contato;

@Repository
public interface ContatoRepository extends JpaRepository <Contato, Long> {
	
	public List <Contato> findAllByNomeContainingIgnoreCase(@Param("nome") String nome);

}
