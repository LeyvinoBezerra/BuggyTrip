package br.edu.ufersa.pw.todo.buggytrip.domain.entities;

import jakarta.persistence.*;
import lombok.*;

@Data
@Entity
@Table(schema = "bt", name = "enderecos_bugueiros")
public class EnderecoBugueiro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "eb_id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "eb_bug_id", referencedColumnName = "bug_id", nullable = false)
    private Bugueiro bugueiro;

    @Column(name = "eb_cidade", nullable = false, length = 50)
    private String cidade;

    @Column(name = "eb_estado", nullable = false, length = 2)
    private String estado;

    @Column(name = "eb_praia", nullable = false, length = 100)
    private String praia; // praia principal onde o bugueiro atua

    @Column(name = "eb_principal")
    private Boolean enderecoPrincipal;
}

