package com.digital.nogran.api.service;

import com.digital.nogran.api.model.EmailDetails;

public interface EmailService {
    String sendSimpleMail(EmailDetails details);

    String sendMailWithAttachment(EmailDetails details);
}
