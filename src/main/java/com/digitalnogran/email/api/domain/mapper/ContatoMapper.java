package com.digitalnogran.email.api.domain.mapper;

import com.digitalnogran.email.api.domain.model.Contato;
import com.digitalnogran.email.api.domain.model.EmailDetails;

public interface ContatoMapper {
    EmailDetails toEmailDetails(Contato contato, String from, String subject);
}
