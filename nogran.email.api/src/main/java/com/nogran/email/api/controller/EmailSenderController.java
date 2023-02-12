package com.nogran.email.api.controller;

import com.nogran.email.api.service.EmailService;
import com.nogran.email.api.domain.model.Contact;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import lombok.var;
import org.springframework.http.HttpStatus;
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

    @PostMapping(value = "/send", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<String> sendMail(@ModelAttribute Contact contact) {
        log.info("POST: /api/v1/save with param Contato Email '{}'", contact.getEmail());
        var isSent = emailService.isMailSent(contact);
        return isSent == false ?
                ResponseEntity.status(HttpStatus.BAD_REQUEST).build() :
                ResponseEntity.status(HttpStatus.CREATED).build();
    }
}