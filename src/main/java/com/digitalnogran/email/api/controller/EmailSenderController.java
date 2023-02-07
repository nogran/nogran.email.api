package com.digitalnogran.email.api.controller;

import com.digitalnogran.email.api.service.EmailService;
import com.digitalnogran.email.api.domain.model.Contact;
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
    public ResponseEntity<String> sendMail(@ModelAttribute Contact contact) {
        log.info("POST: /api/v1/save with params Email '{}'", contact.getEmail());
        emailService.manageEmail(contact, from, subject);
        return ResponseEntity.ok().build();
    }
}
