package com.digitalnogran.email.api.service;

import com.digitalnogran.email.api.repository.ContatoRepository;
import com.digitalnogran.email.api.domain.mapper.ContatoMapper;
import com.digitalnogran.email.api.domain.model.Contato;
import com.digitalnogran.email.api.domain.model.EmailDetails;
import lombok.AllArgsConstructor;
import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class ContatoService {
    private final ContatoRepository contatoRepository;
    private final ContatoMapper contatoMapper = Mappers.getMapper(ContatoMapper.class);

    public List<Contato> findAll() {
        return contatoRepository.findAll();
    }

    public Optional<Contato> findById(Long id) {
        return contatoRepository.findById(id);
    }

    public List<Contato> findByName(String name) {
        return contatoRepository.findAllByNameContainingIgnoreCase(name);
    }

    public Contato save(Contato contato) {
        return contatoRepository.save(contato);
    }

    public EmailDetails buildEmail(Contato contato, String from, String subject) {
        return contatoMapper.toEmailDetails(contato, from, subject);
    }
}
