package com.nogran.email.api.controller;

import com.nogran.email.api.domain.dto.ContactDTO;
import com.nogran.email.api.domain.model.Contact;
import com.nogran.email.api.service.ContactService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import lombok.var;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/v1")
@CrossOrigin(origins = "*", allowedHeaders = "*")
@AllArgsConstructor
@Slf4j
public class ContactController {
    private final ContactService contactService;

    @GetMapping
    public ResponseEntity<List<ContactDTO>> findAll() {
        log.info("GET: /api/v1/");
        return ResponseEntity.ok(contactService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ContactDTO> findById(@PathVariable Long id) {
        log.info("GET: /api/v1/{id} with param ID '{}'", id);
        var contact = contactService.findById(id);
        if (!contact.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.ok(contactService.buildContractDTO(contact.get()));
    }

    @GetMapping("/name/{name}")
    public ResponseEntity<List<ContactDTO>> findAllByNameContainingIgnoreCase(@PathVariable String name) {
        log.info("GET: /api/v1/{name} with param Name '{}'", name);
        var contacts = contactService.findAllByNameContainingIgnoreCase(name);
        if (contacts.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.ok(contactService.buildContractDTOs(contacts));
    }

    @PostMapping("/save")
    public ResponseEntity<Contact> saveContato(@Valid @RequestBody Contact contact) {
        log.info("POST: /api/v1/save with param Email '{}'", contact.getEmail());
        var savedContact = contactService.save(contact);
        return savedContact == null ?
                ResponseEntity.status(HttpStatus.BAD_REQUEST).build() :
                ResponseEntity.status(HttpStatus.CREATED).body(savedContact);
    }
}
