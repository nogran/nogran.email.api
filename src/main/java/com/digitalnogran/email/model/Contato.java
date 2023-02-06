package com.digitalnogran.email.model;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.Data;
import org.hibernate.annotations.UpdateTimestamp;

@Entity
@Table(name = "tb_contato")
@Data
public class Contato {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "O atributo nome é obrigatório e não pode utilizar espaços em branco!")
    @Size(min = 5, max = 100, message = "O atributo nome deve conter no mínimo 05 e no máximo 100 caracteres.")
    private String nome;

    @NotNull(message = "O atributo telefone é obrigatório!")
    @Size(min = 10, max = 14, message = "O atributo telefone deve conter no mínimo 10 e no máximo 14 caracteres.")
    private String telefone;

    @NotNull(message = "O atributo E-mail é obrigatório!")
    @Email
    private String email;

    @NotNull(message = "O atributo Mensagem é obrigatório!")
    private String mensagem;

    @UpdateTimestamp
    private LocalDateTime data;
}
