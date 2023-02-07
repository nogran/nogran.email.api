package com.digitalnogran.email.api.domain.mapper;

import com.digitalnogran.email.api.domain.model.Contact;
import com.digitalnogran.email.api.domain.model.EmailDetails;
import org.mapstruct.Mapper;

import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

@Mapper(componentModel = "spring")
public class ContatoMapperImpl implements ContatoMapper {
    public EmailDetails toEmailDetails(Contact contact, String from, String subject) {
        EmailDetails emailDetails = new EmailDetails();

        emailDetails.setRecipient(from);
        emailDetails.setMsgBody(
                String.format("Nome: %s\n" +
                                "Email: %s\n" +
                                "Telefone: %s\n" +
                                "Mensagem: %s\n" +
                                "Envio: %s\n",
                        contact.getName(), contact.getEmail(),
                        contact.getPhone(), contact.getMessage(),
                        contact.getDate()
                                .atZone(ZoneId.of("America/Sao_Paulo"))
                                .format(DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm"))));
        emailDetails.setSubject(subject);
        return emailDetails;
    }
}
