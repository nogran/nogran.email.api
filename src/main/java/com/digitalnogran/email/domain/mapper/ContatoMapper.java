package com.digitalnogran.email.domain.mapper;

import com.digitalnogran.email.domain.model.Contato;
import com.digitalnogran.email.domain.model.EmailDetails;

public interface ContatoMapper {
    EmailDetails toEmailDetails(Contato contato, String from, String subject);
}
