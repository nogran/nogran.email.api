package com.digitalnogran.email.api.domain.mapper;

import com.digitalnogran.email.api.domain.model.Contact;
import com.digitalnogran.email.api.domain.model.EmailDetails;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public class ContatoMapperImpl implements ContatoMapper {
    public EmailDetails toEmailDetails(Contact contact, String from, String subject) {
        EmailDetails emailDetails = new EmailDetails();

        emailDetails.setRecipient(from);
        emailDetails.setMsgBody(
                String.format("Email: %s\n",
                        "Nome: %s\n",
                        "Telefone: %s\n",
                        "Data: %s\n",
                        "Mensagem: %s\n",
                        contact.getEmail(), contact.getName(),
                        contact.getPhone(), contact.getDate(), contact.getMessage()));

        emailDetails.setSubject(subject);

        return emailDetails;
    }
}
