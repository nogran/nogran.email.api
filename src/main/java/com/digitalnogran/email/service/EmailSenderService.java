package com.digitalnogran.email.service;

import com.digitalnogran.email.domain.model.EmailDetails;

public interface EmailSenderService {
    void sendSimpleMail(EmailDetails details);

    void sendMailWithAttachment(EmailDetails details);
}
