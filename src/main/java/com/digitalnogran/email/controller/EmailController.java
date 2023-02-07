package com.digitalnogran.email.controller;

import com.digitalnogran.email.model.EmailDetails;
import com.digitalnogran.email.service.EmailSenderService;
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
public class EmailController {
    private final EmailSenderService emailSenderService;

    @PostMapping(value = "/sendMail", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<String> sendMail(@ModelAttribute EmailDetails details) {
        log.info("POST: /api/v1/sendMail with param Recipient Address '{}'", details.getRecipient());
        emailSenderService.sendSimpleMail(details);
        return ResponseEntity.ok().build();
    }

    @PostMapping(value = "/sendMailWithAttachment", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<String> sendMailWithAttachment(@ModelAttribute EmailDetails details) {
        log.info("POST: /api/v1/sendMail with param Recipient Address '{}'", details.getRecipient());
        emailSenderService.sendMailWithAttachment(details);
        return ResponseEntity.ok().build();
    }
}
