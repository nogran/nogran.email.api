package com.nogran.email.api.service;

import com.nogran.email.api.domain.dto.ContactDTO;
import com.nogran.email.api.repository.ContactRepository;
import com.nogran.email.api.domain.mapper.ContactMapper;
import com.nogran.email.api.domain.model.Contact;
import lombok.AllArgsConstructor;
import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class ContactService {
    private final ContactRepository contactRepository;
    private final ContactMapper contactMapper = Mappers.getMapper(ContactMapper.class);

    public List<Contact> findAll() {
        return contactRepository.findAll();
    }

    public List<ContactDTO> getAll() {
        List<ContactDTO> contactDTOs = new ArrayList<>();
        List<Contact> contacts = contactRepository.findAll();

        for (Contact item : contacts) {
            contactDTOs.add(buildContractDTO(item));
        }
        return contactDTOs;
    }

    public Optional<Contact> findById(Long id) {
        return contactRepository.findById(id);
    }

    public ContactDTO buildContractDTO(Contact model) {
        return contactMapper.modelToDto(model);
    }

    public List<ContactDTO> buildContractDTOs(List<Contact> models) {
        List<ContactDTO> contactDTOs = new ArrayList<>();
        for (Contact contact : models) {
            contactDTOs.add(buildContractDTO(contact));
        }
        return contactDTOs;
    }

    public List<Contact> findAllByNameContainingIgnoreCase(String name) {
        return contactRepository.findAllByNameContainingIgnoreCase(name);
    }

    public Contact save(Contact contact) {
        return contactRepository.save(contact);
    }
}
