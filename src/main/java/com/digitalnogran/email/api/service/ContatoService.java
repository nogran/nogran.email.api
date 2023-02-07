package com.digitalnogran.email.api.service;

import com.digitalnogran.email.api.domain.dto.ContactDTO;
import com.digitalnogran.email.api.repository.ContatoRepository;
import com.digitalnogran.email.api.domain.mapper.ContatoMapper;
import com.digitalnogran.email.api.domain.model.Contact;
import com.digitalnogran.email.api.domain.model.EmailDetails;
import lombok.AllArgsConstructor;
import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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

    public List<ContactDTO> getAll() {
        List<ContactDTO> contactDTOs = new ArrayList<>();
        List<Contact> contacts = contatoRepository.findAll();

        for (Contact item : contacts) {
            contactDTOs.add(buildContractDTO(item));
        }
        return contactDTOs;
    }

    public Optional<Contact> findById(Long id) {
        return contatoRepository.findById(id);
    }

    public ContactDTO buildContractDTO(Contact model) {
        return contatoMapper.modelToDto(model);
    }

    public List<ContactDTO> buildContractDTOs(List<Contact> models) {
        List<ContactDTO> contactDTOs = new ArrayList<>();
        for (Contact contact : models) {
            contactDTOs.add(buildContractDTO(contact));
        }
        return contactDTOs;
    }

    public List<Contact> findAllByNameContainingIgnoreCase(String name) {
        return contatoRepository.findAllByNameContainingIgnoreCase(name);
    }

    public Contact save(Contact contact) {
        return contatoRepository.save(contact);
    }

    public EmailDetails buildEmail(Contact contact, String from, String subject) {
        return contatoMapper.toEmailDetails(contact, from, subject);
    }
}
