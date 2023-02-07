package com.digitalnogran.email.api.controller;

import java.util.List;

import javax.validation.Valid;

import com.digitalnogran.email.api.service.ContatoService;
import com.digitalnogran.email.api.domain.model.Contato;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
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
    public ResponseEntity<List<Contato>> findAll() {
        log.info("GET: /api/v1/");
        return ResponseEntity.ok(contatoService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Contato> findById(@PathVariable Long id) {
        log.info("GET: /api/v1/{id} with param ID '{}'", id);
        return contatoService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/nome/{name}")
    public ResponseEntity<List<Contato>> findByName(@PathVariable String name) {
        log.info("GET: /api/v1/{id} with param Name '{}'", name);
        return ResponseEntity.ok(contatoService.findByName(name));
    }

    @PostMapping("/save")
    public ResponseEntity<Contato> saveContato(@Valid @RequestBody Contato contato) {
        log.info("POST: /api/v1/save with params ID '{}' and Email '{}'", contato.getId(), contato.getEmail());
        return ResponseEntity.status(HttpStatus.CREATED).body(contatoService.save(contato));
    }
}
