package com.digitalnogran.email.api.service;

import com.digitalnogran.email.api.repository.ContatoRepository;
import com.digitalnogran.email.api.domain.mapper.ContatoMapper;
import com.digitalnogran.email.api.domain.model.Contact;
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

    public List<Contact> findAll() {
        return contatoRepository.findAll();
    }

    public Optional<Contact> findById(Long id) {
        return contatoRepository.findById(id);
    }

    public List<Contact> findByName(String name) {
        return contatoRepository.findAllByNameContainingIgnoreCase(name);
    }

    public Contact save(Contact contact) {
        return contatoRepository.save(contact);
    }

    public EmailDetails buildEmail(Contact contact, String from, String subject) {
        return contatoMapper.toEmailDetails(contact, from, subject);
    }
}
