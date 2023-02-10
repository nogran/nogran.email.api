package com.nogran.email.api.controller;

import com.nogran.email.api.domain.dto.ContactDTO;
import com.nogran.email.api.mock.ContactDTOMock;
import com.nogran.email.api.service.ContactService;
import com.nogran.email.api.service.EmailService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
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
}
