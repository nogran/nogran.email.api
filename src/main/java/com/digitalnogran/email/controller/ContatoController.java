package com.digitalnogran.email.controller;

import java.util.List;

import javax.validation.Valid;

import com.digitalnogran.email.model.Contato;
import com.digitalnogran.email.service.ContatoService;
import lombok.AllArgsConstructor;
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
@RequestMapping("/contato")
@CrossOrigin(origins = "*", allowedHeaders = "*")
@AllArgsConstructor
public class ContatoController {

    private final ContatoService contatoService;

    @GetMapping
    public ResponseEntity<List<Contato>> findAll() {
        return ResponseEntity.ok(contatoService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Contato> findById(@PathVariable Long id) {
        return contatoService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/nome/{name}")
    public ResponseEntity<List<Contato>> findByName(@PathVariable String name) {
        return ResponseEntity.ok(contatoService.findByName(name));
    }

    @PostMapping("/save")
    public ResponseEntity<Contato> saveContato(@Valid @RequestBody Contato contato) {
        return ResponseEntity.status(HttpStatus.CREATED).body(contatoService.save(contato));
    }
}
