package br.edu.ufersa.pw.todo.buggytrip.domain.entities;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

public class Avaliacao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private int nota;
    private String comentario;

    @ManyToOne
    private Usuario bugueiro;

    @ManyToOne
    private Usuario avaliador;
}
