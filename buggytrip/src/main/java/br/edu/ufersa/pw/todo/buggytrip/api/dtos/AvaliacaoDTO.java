package br.edu.ufersa.pw.todo.buggytrip.api.dtos;

import lombok.Data;

@Data
public class AvaliacaoDTO {
    private int seguranca;
    private int conhecimentoRoteiro;
    private int confortoVeiculo;
    private int simpatiaMotorista;
    private int experienciaGeral;
    private int adaptabilidade;
    private int paradasInteressantes;
    private String diferencial;
    private String feedback;
    private Long avaliadorId;
    private Long bugueiroId;
}