package com.nogran.email.api.mock;

import com.nogran.email.api.domain.dto.ContactDTO;
import com.nogran.email.api.domain.model.Contact;

import java.util.ArrayList;
import java.util.List;

public class ContactDTOMock {

    public static List<ContactDTO> createContacts() {
        List<ContactDTO> contacts = new ArrayList<>();

        contacts.add(createContact1());
        contacts.add(createContact2());

        return contacts;
    }

    public static ContactDTO createContact1() {
        Contact model = ContactMock.createContact1();
        ContactDTO contact = new ContactDTO();

        contact.setId(model.getId());
        contact.setName(model.getName());
        contact.setPhone(model.getPhone());
        contact.setEmail(model.getEmail());
        contact.setMessage(model.getMessage());
        contact.setDate(model.getDate());

        return contact;
    }

    public static ContactDTO createContact2() {
        Contact model = ContactMock.createContact2();
        ContactDTO contact = new ContactDTO();

        contact.setId(model.getId());
        contact.setName(model.getName());
        contact.setPhone(model.getPhone());
        contact.setEmail(model.getEmail());
        contact.setMessage(model.getMessage());
        contact.setDate(model.getDate());

        return contact;
    }
}
