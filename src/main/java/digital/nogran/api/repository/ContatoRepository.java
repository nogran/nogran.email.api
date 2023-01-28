package digital.nogran.api.repository;

import java.util.List;

import digital.nogran.api.model.Contato;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ContatoRepository extends JpaRepository <Contato, Long> {
	
	public List <Contato> findAllByNomeContainingIgnoreCase(@Param("nome") String nome);

}
