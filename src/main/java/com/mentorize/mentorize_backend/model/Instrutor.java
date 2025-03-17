package com.mentorize.mentorize_backend.model;

import java.time.LocalDate;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Instrutor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nome;

    @Column(nullable = false)
    private String sobrenome;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false)
    private String senha;

    @Column(nullable = false)
    private LocalDate dataCadastro = LocalDate.now();

    @PrePersist
    @PreUpdate
    private void criptografarSenha() {
        if (!this.senha.startsWith("$2a$")) { // Evita recriptografia
            this.senha = new BCryptPasswordEncoder().encode(this.senha);
        }
    }
}
