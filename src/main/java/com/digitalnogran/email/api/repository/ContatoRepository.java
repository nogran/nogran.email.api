package com.digitalnogran.email.api.repository;

import java.util.List;

import com.digitalnogran.email.api.domain.model.Contato;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ContatoRepository extends JpaRepository<Contato, Long> {
    List<Contato> findAllByNameContainingIgnoreCase(@Param("name") String name);
}
