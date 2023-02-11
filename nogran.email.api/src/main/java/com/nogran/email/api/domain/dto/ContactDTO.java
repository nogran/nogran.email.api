package com.nogran.email.api.domain.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class ContactDTO {
    private Long id;
    private String name;
    private String phone;
    private String email;
    private String message;
    private LocalDateTime date;
}
