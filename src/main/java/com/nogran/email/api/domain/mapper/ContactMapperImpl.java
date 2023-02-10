package com.nogran.email.api.domain.mapper;

import com.nogran.email.api.domain.dto.ContactDTO;
import com.nogran.email.api.domain.model.Contact;
import com.nogran.email.api.domain.model.Email;
import org.mapstruct.Mapper;

import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

@Mapper(componentModel = "spring")
public class ContactMapperImpl implements ContactMapper {
    public ContactDTO modelToDto(Contact model) {
        ContactDTO contactDTO = new ContactDTO();

        contactDTO.setId(model.getId());
        contactDTO.setName(model.getName());
        contactDTO.setPhone(model.getPhone());
        contactDTO.setEmail(model.getEmail());
        contactDTO.setMessage(model.getMessage());
        contactDTO.setDate(model.getDate());

        return contactDTO;
    }

    public Email toEmail(Contact contact, String from, String subject) {
        Email email = new Email();

        email.setRecipient(from);
        email.setMsgBody(
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
        email.setSubject(subject);
        return email;
    }
}
