package com.digitalnogran.email.service;

import com.digitalnogran.email.model.Contato;
import com.digitalnogran.email.repository.ContatoRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class ContatoService {

    private final ContatoRepository contatoRepository;

    public List<Contato> findAll() {
        return contatoRepository.findAll();
    }

    public Optional<Contato> findById(Long id) {
        return contatoRepository.findById(id);
    }

    public List<Contato> findByName(String name) {
        return contatoRepository.findAllByNomeContainingIgnoreCase(name);
    }

    public Contato save(Contato contato) {
        return contatoRepository.save(contato);
    }
}
