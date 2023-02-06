package com.digitalnogran.email.controller;

import com.digitalnogran.email.model.EmailDetails;
import com.digitalnogran.email.service.EmailService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@AllArgsConstructor
public class EmailController {
    private final EmailService emailService;

    @PostMapping("/sendMail")
    public String
    sendMail(@RequestBody EmailDetails details) {
        String status
                = emailService.sendSimpleMail(details);
        return status;
    }

    @PostMapping("/sendMailWithAttachment")
    public String sendMailWithAttachment(
            @RequestBody EmailDetails details) {
        String status
                = emailService.sendMailWithAttachment(details);
        return status;
    }
}
