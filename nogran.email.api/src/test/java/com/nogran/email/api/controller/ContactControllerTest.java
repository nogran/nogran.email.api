package com.nogran.email.api.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.nogran.email.api.domain.dto.ContactDTO;
import com.nogran.email.api.domain.model.Contact;
import com.nogran.email.api.mock.ContactDTOMock;
import com.nogran.email.api.mock.ContactMock;
import com.nogran.email.api.service.ContactService;
import com.nogran.email.api.service.EmailService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.Matchers.hasSize;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest
public class ContactControllerTest {
    @Autowired
    private MockMvc mockMvc;
    @MockBean
    private ContactService contactService;
    @MockBean
    private EmailService emailService;

    @Test
    public void findAll_ShouldReturnContacts() throws Exception {
        List<ContactDTO> contacts = ContactDTOMock.createContacts();

        when(contactService.getAll()).thenReturn(contacts);

        mockMvc.perform(get("/api/v1/")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].name", is("John Doe")))
                .andExpect(jsonPath("$[0].email", is("john.doe@email.com")))
                .andExpect(jsonPath("$[1].name", is("Jane Doe")))
                .andExpect(jsonPath("$[1].email", is("jane.doe@email.com")));
    }

    @Test
    public void testFindById() throws Exception {
        Contact contact = ContactMock.createContact1();
        ContactDTO contactDTO = ContactDTOMock.createContact1();

        when(contactService.findById(1L)).thenReturn(Optional.of(contact));
        when(contactService.buildContractDTO(any(Contact.class))).thenReturn(contactDTO);

        mockMvc.perform(get("/api/v1/1")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id", is(1)))
                .andExpect(jsonPath("$.name", is("John Doe")))
                .andExpect(jsonPath("$.email", is("john.doe@email.com")));

        when(contactService.findById(2L)).thenReturn(Optional.empty());

        mockMvc.perform(get("/api/v1/2"))
                .andExpect(status().isNotFound());
    }

    @Test
    public void findAllByNameContainingIgnoreCase_ShouldReturnContactsList() throws Exception {
        List<Contact> contacts = ContactMock.createContacts();
        List<ContactDTO> expected = ContactDTOMock.createContacts();

        when(contactService.findAllByNameContainingIgnoreCase(anyString())).thenReturn(contacts);
        when(contactService.buildContractDTOs(contacts)).thenReturn(expected);

        mockMvc.perform(get("/api/v1/name/doe")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(2)))
                .andExpect(jsonPath("$[0].id", is(expected.get(0).getId().intValue())))
                .andExpect(jsonPath("$[0].name", is(expected.get(0).getName())))
                .andExpect(jsonPath("$[1].email", is(expected.get(1).getEmail())))
                .andExpect(jsonPath("$[1].phone", is(expected.get(1).getPhone())));
    }

    @Test
    public void findAllByNameContainingIgnoreCase_ShouldReturnNotFound() throws Exception {
        List<Contact> contacts = new ArrayList<>();
        List<ContactDTO> expected = ContactDTOMock.createContacts();

        when(contactService.findAllByNameContainingIgnoreCase(anyString())).thenReturn(contacts);

        mockMvc.perform(get("/api/v1/name/doe")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isNotFound());
    }


    @Test
    public void saveContato_ShouldReturnBadRequest_WhenEmailAlreadyExists() throws Exception {
        Contact contact = ContactMock.createContact1();
        when(contactService.save(contact)).thenReturn(null);

        ObjectMapper objectMapper = new ObjectMapper();

        mockMvc.perform(post("/api/v1/save")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.registerModule(new JavaTimeModule()).writeValueAsString(contact)))
                .andExpect(status().isBadRequest());
    }

    @Test
    public void saveContato_ShouldReturnCreated_WhenSuccess() throws Exception {
        Contact contact = ContactMock.createContact1();
        when(contactService.save(contact)).thenReturn(contact);

        ObjectMapper objectMapper = new ObjectMapper();

        mockMvc.perform(post("/api/v1/save")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.registerModule(new JavaTimeModule()).writeValueAsString(contact)))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.id", is(contact.getId().intValue())))
                .andExpect(jsonPath("$.name", is(contact.getName())))
                .andExpect(jsonPath("$.email", is(contact.getEmail())))
                .andExpect(jsonPath("$.phone", is(contact.getPhone())));
    }
}
