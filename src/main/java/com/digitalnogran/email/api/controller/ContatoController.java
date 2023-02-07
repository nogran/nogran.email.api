package com.digitalnogran.email.api.controller;

import java.util.List;

import javax.validation.Valid;

import com.digitalnogran.email.api.domain.dto.ContactDTO;
import com.digitalnogran.email.api.service.ContatoService;
import com.digitalnogran.email.api.domain.model.Contact;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import lombok.var;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
@CrossOrigin(origins = "*", allowedHeaders = "*")
@AllArgsConstructor
@Slf4j
public class ContatoController {
    private final ContatoService contatoService;

    @GetMapping
    public ResponseEntity<List<ContactDTO>> findAll() {
        log.info("GET: /api/v1/");
        return ResponseEntity.ok(contatoService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ContactDTO> findById(@PathVariable Long id) {
        log.info("GET: /api/v1/{id} with param ID '{}'", id);
        var contact = contatoService.findById(id);
        if (!contact.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.ok(contatoService.buildContractDTO(contact.get()));
    }

    @GetMapping("/name/{name}")
    public ResponseEntity<List<ContactDTO>> findAllByNameContainingIgnoreCase(@PathVariable String name) {
        log.info("GET: /api/v1/{name} with param Name '{}'", name);
        var contacts = contatoService.findAllByNameContainingIgnoreCase(name);
        if (contacts.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.ok(contatoService.buildContractDTOs(contacts));
    }

    @PostMapping("/save")
    public ResponseEntity<Contact> saveContato(@Valid @RequestBody Contact contact) {
        log.info("POST: /api/v1/save with param Email '{}'", contact.getEmail());
        var savedContact = contatoService.save(contact);
        return savedContact == null ?
                ResponseEntity.status(HttpStatus.BAD_REQUEST).build() :
                ResponseEntity.status(HttpStatus.CREATED).body(savedContact);
    }
}
