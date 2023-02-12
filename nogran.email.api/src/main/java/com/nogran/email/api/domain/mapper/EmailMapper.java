package com.nogran.email.api.domain.mapper;

import com.nogran.email.api.domain.model.Contact;
import com.nogran.email.api.domain.model.Email;

public interface EmailMapper {
    Email toEmail(Contact contact, String subject, String to);
}
