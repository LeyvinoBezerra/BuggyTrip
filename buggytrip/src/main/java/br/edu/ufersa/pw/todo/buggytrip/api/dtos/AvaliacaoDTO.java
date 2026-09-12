package br.edu.ufersa.pw.todo.buggytrip.api.dtos;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class AvaliacaoDTO {
    @Min(1) @Max(5) private int seguranca;
    @Min(1) @Max(5) private int conhecimentoRoteiro;
    @Min(1) @Max(5) private int confortoVeiculo;
    @Min(1) @Max(5) private int simpatiaMotorista;
    @Min(1) @Max(5) private int experienciaGeral;
    @Min(1) @Max(5) private int adaptabilidade;
    @Min(1) @Max(5) private int paradasInteressantes;
    private String diferencial;
    private String feedback;
    @NotNull private Long avaliadorId;
    @NotNull private Long bugueiroId;

    public int getSeguranca() { return seguranca; }
    public int getConhecimentoRoteiro() { return conhecimentoRoteiro; }
    public int getConfortoVeiculo() { return confortoVeiculo; }
    public int getSimpatiaMotorista() { return simpatiaMotorista; }
    public int getExperienciaGeral() { return experienciaGeral; }
    public int getAdaptabilidade() { return adaptabilidade; }
    public int getParadasInteressantes() { return paradasInteressantes; }
    public String getDiferencial() { return diferencial; }
    public String getFeedback() { return feedback; }
    public Long getAvaliadorId() { return avaliadorId; }
    public Long getBugueiroId() { return bugueiroId; }
}