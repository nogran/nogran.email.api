package com.digitalnogran.email.api.service;

import com.digitalnogran.email.api.domain.model.EmailDetails;

public interface EmailSenderService {
    void sendSimpleMail(EmailDetails details);

    void sendMailWithAttachment(EmailDetails details);
}
