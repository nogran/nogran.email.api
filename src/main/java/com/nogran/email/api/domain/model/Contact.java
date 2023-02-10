package com.nogran.email.api.domain.model;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.Data;
import org.hibernate.annotations.UpdateTimestamp;

@Entity
@Table(name = "contact")
@Data
public class Contact {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "O atributo nome é obrigatório e não pode utilizar espaços em branco!")
    private String name;

    @NotNull(message = "O atributo telefone é obrigatório!")
    private String phone;

    @NotNull(message = "O atributo E-mail é obrigatório!")
    @Email
    private String email;

    @NotNull(message = "O atributo Mensagem é obrigatório!")
    private String message;

    @UpdateTimestamp
    private LocalDateTime date;
}
