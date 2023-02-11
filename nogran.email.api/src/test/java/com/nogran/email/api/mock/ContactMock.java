package com.nogran.email.api.mock;


import com.nogran.email.api.domain.model.Contact;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class ContactMock {

    public static List<Contact> createContacts() {
        List<Contact> contacts = new ArrayList<>();

        contacts.add(createContact1());
        contacts.add(createContact2());

        return contacts;
    }

    public static Contact createContact1() {
        Contact contact = new Contact();

        contact.setId(1L);
        contact.setName("John Doe");
        contact.setPhone("00999999999");
        contact.setEmail("john.doe@email.com");
        contact.setMessage("Message test");
        contact.setDate(LocalDateTime.now());

        return contact;
    }

    public static Contact createContact2() {
        Contact contact = new Contact();

        contact.setId(2L);
        contact.setName("Jane Doe");
        contact.setPhone("00999999999");
        contact.setEmail("jane.doe@email.com");
        contact.setMessage("Message test");
        contact.setDate(LocalDateTime.now());

        return contact;
    }
}
