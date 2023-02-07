package com.digitalnogran.email.api.domain.mapper;

import com.digitalnogran.email.api.domain.model.Contato;
import com.digitalnogran.email.api.domain.model.EmailDetails;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public class ContatoMapperImpl implements ContatoMapper {
    public EmailDetails toEmailDetails(Contato contato, String from, String subject) {
        EmailDetails emailDetails = new EmailDetails();

        emailDetails.setRecipient(from);
        emailDetails.setMsgBody(
                String.format("Email: %s\n",
                        "Nome: %s\n",
                        "Telefone: %s\n",
                        "Data: %s\n",
                        "Mensagem: %s\n",
                        contato.getEmail(), contato.getName(),
                        contato.getPhone(), contato.getDate(), contato.getMessage()));

        emailDetails.setSubject(subject);

        return emailDetails;
    }
}
