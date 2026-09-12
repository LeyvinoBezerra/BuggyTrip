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

    public void setSeguranca(int value) { this.seguranca = value; }
    public void setConhecimentoRoteiro(int value) { this.conhecimentoRoteiro = value; }
    public void setConfortoVeiculo(int value) { this.confortoVeiculo = value; }
    public void setSimpatiaMotorista(int value) { this.simpatiaMotorista = value; }
    public void setExperienciaGeral(int value) { this.experienciaGeral = value; }
    public void setAdaptabilidade(int value) { this.adaptabilidade = value; }
    public void setParadasInteressantes(int value) { this.paradasInteressantes = value; }
    public void setDiferencial(String value) { this.diferencial = value; }
    public void setFeedback(String value) { this.feedback = value; }
    public void setAvaliador(UsuarioEntity value) { this.avaliador = value; }
    public void setBugueiro(UsuarioEntity value) { this.bugueiro = value; }
}
