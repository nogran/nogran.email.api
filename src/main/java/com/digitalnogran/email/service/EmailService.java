package com.digitalnogran.email.service;

import com.digitalnogran.email.model.EmailDetails;

public interface EmailService {
    void sendSimpleMail(EmailDetails details);

    void sendMailWithAttachment(EmailDetails details);
}
