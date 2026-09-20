package br.edu.ufersa.pw.todo.buggytrip.domain.entities;

import jakarta.persistence.*;
import lombok.*;

@Data
@Entity
@Table(schema = "bt", name = "avaliacoes")
public class Avaliacao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ava_id")
    private Long id;

    @Column(name = "ava_seguranca", nullable = false)
    private int seguranca;

    @Column(name = "ava_conhecimento_roteiro", nullable = false)
    private int conhecimentoRoteiro;

    @Column(name = "ava_conforto_veiculo", nullable = false)
    private int confortoVeiculo;

    @Column(name = "ava_simpatia_motorista", nullable = false)
    private int simpatiaMotorista;

    @Column(name = "ava_experiencia_geral", nullable = false)
    private int experienciaGeral;

    @Column(name = "ava_adaptabilidade", nullable = false)
    private int adaptabilidade;

    @Column(name = "ava_paradas_interessantes", nullable = false)
    private int paradasInteressantes;

    @Column(name = "ava_diferencial", length = 255)
    private String diferencial;

    @Column(name = "ava_feedback", length = 500)
    private String feedback;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ava_avaliador_id", referencedColumnName = "usu_id", nullable = false)
    private Usuario avaliador; // cliente

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ava_bugueiro_id", referencedColumnName = "usu_id", nullable = false)
    private Usuario bugueiro; // motorista
}
