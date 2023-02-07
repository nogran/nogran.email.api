package com.digitalnogran.email.api.service;

import com.digitalnogran.email.api.domain.model.Contato;
import com.digitalnogran.email.api.domain.model.EmailDetails;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
@Slf4j
public class EmailService {
    private final ContatoService contatoService;
    private final EmailSenderService emailSenderService;

    public void manageEmail(Contato contato, String from, String subject) {
        try {
            contatoService.save(contato);
            EmailDetails emailDetails = contatoService.buildEmail(contato, from, subject);
            emailSenderService.sendSimpleMail(emailDetails);
        } catch (Exception e) {
            log.error("Error while processing email.", e);
        }
    }
}
