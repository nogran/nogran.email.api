package com.nogran.email.api.service;

import com.nogran.email.api.domain.mapper.EmailMapper;
import com.nogran.email.api.domain.model.Contact;
import com.nogran.email.api.domain.model.Email;
import com.nogran.email.api.properties.EmailSenderProperties;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
@Slf4j
public class EmailService {
    private final ContactService contactService;
    private final EmailSenderService emailSenderService;
    private final EmailSenderProperties emailProperties;
    private final EmailMapper emailMapper = Mappers.getMapper(EmailMapper.class);

    public boolean isMailSent(Contact contact) {
        try {
            contactService.save(contact);
            Email email = buildEmail(contact);
            emailSenderService.sendSimpleMail(email);
            return true;
        } catch (Exception e) {
            log.error("Error while processing email.", e);
            return false;
        }
    }

    private Email buildEmail(Contact contact) {
        return emailMapper.toEmail(contact, emailProperties.getSubject(), emailProperties.getTo());
    }
}
