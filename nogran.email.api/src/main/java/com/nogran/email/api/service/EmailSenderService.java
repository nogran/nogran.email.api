package com.nogran.email.api.service;

import com.nogran.email.api.domain.model.Email;

public interface EmailSenderService {
    void sendSimpleMail(Email details);

    void sendMailWithAttachment(Email details);
}
