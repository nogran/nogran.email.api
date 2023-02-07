package com.digitalnogran.email.api.domain.mapper;

import com.digitalnogran.email.api.domain.dto.ContactDTO;
import com.digitalnogran.email.api.domain.model.Contact;
import com.digitalnogran.email.api.domain.model.EmailDetails;

public interface ContatoMapper {
    EmailDetails toEmailDetails(Contact contact, String from, String subject);

    ContactDTO modelToDto(Contact contact);
}
