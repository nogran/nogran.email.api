package com.nogran.email.api.service;

import com.nogran.email.api.domain.model.Contact;
import com.nogran.email.api.domain.model.Email;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
@Slf4j
public class EmailService {
    private final ContactService contactService;
    private final EmailSenderService emailSenderService;

    public boolean isMailSent(Contact contact, String from, String subject) {
        try {
            contactService.save(contact);
            Email email = contactService.buildEmail(contact, from, subject);
            emailSenderService.sendSimpleMail(email);
            return true;
        } catch (Exception e) {
            log.error("Error while processing email.", e);
            return false;
        }
    }
}
