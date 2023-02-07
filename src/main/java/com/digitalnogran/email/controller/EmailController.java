package com.digitalnogran.email.controller;

import com.digitalnogran.email.model.EmailDetails;
import com.digitalnogran.email.service.EmailService;
import lombok.AllArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1")
@CrossOrigin(origins = "*", allowedHeaders = "*")
@AllArgsConstructor
public class EmailController {
    private final EmailService emailService;

    @PostMapping(value = "/sendMail", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<String> sendMail(@ModelAttribute EmailDetails details) {
        emailService.sendSimpleMail(details);
        return ResponseEntity.ok().build();
    }

    @PostMapping(value = "/sendMailWithAttachment", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<String> sendMailWithAttachment(@ModelAttribute EmailDetails details) {
        emailService.sendMailWithAttachment(details);
        return ResponseEntity.ok().build();
    }
}
