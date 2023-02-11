package com.nogran.email.api.mock;

import com.nogran.email.api.domain.dto.ContactDTO;

import java.time.LocalDateTime;
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
        ContactDTO contact = new ContactDTO();

        contact.setId(1L);
        contact.setName("John Doe");
        contact.setPhone("00999999999");
        contact.setEmail("john.doe@email.com");
        contact.setMessage("Message test");
        contact.setDate(LocalDateTime.now());

        return contact;
    }

    public static ContactDTO createContact2() {
        ContactDTO contact = new ContactDTO();

        contact.setId(2L);
        contact.setName("Jane Doe");
        contact.setPhone("00999999999");
        contact.setEmail("jane.doe@email.com");
        contact.setMessage("Message test");
        contact.setDate(LocalDateTime.now());

        return contact;
    }
}
