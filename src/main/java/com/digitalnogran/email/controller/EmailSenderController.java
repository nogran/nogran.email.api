package com.digitalnogran.email.controller;

import com.digitalnogran.email.domain.model.Contato;
import com.digitalnogran.email.service.EmailService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1")
@CrossOrigin(origins = "*", allowedHeaders = "*")
@AllArgsConstructor
@Slf4j
public class EmailSenderController {
    private final EmailService emailService;
    private static String from = "no-reply@digitalnogran.com.br";
    private static String subject = "Contato";

    @PostMapping(value = "/save", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<String> sendMail(@ModelAttribute Contato contato) {
        log.info("POST: /api/v1/save with params ID '{}' and Email '{}'", contato.getId(), contato.getEmail());
        emailService.manageEmail(contato, from, subject);
        return ResponseEntity.ok().build();
    }
}
