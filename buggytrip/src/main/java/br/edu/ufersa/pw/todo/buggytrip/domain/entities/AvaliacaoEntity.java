package br.edu.ufersa.pw.todo.buggytrip.domain.entities;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "avaliacoes")
public class AvaliacaoEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false) private int seguranca;
    @Column(nullable = false) private int conhecimentoRoteiro;
    @Column(nullable = false) private int confortoVeiculo;
    @Column(nullable = false) private int simpatiaMotorista;
    @Column(nullable = false) private int experienciaGeral;
    @Column(nullable = false) private int adaptabilidade;
    @Column(nullable = false) private int paradasInteressantes;

    @Column(length = 255) private String diferencial;
    @Column(length = 500) private String feedback;

    @ManyToOne
    @JoinColumn(name = "avaliador_id")
    private UsuarioEntity avaliador; // cliente

    @ManyToOne
    @JoinColumn(name = "bugueiro_id")
    private UsuarioEntity bugueiro; // motorista
}
