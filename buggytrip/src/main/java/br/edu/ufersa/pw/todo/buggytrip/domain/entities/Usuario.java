package br.edu.ufersa.pw.todo.buggytrip.domain.entities;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private String email;
    private String senha;
    private String tipo; // "BUGUEIRO" ou "AVALIADOR"
}
