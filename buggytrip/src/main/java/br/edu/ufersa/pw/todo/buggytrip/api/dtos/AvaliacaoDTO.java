package br.edu.ufersa.pw.todo.buggytrip.api.dtos;




package br.edu.ufersa.pw.todo.buggytrip.api.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record AvaliacaoDTO(
        @NotBlank(message = "Segurança não pode estar em branco") String seguranca,
        @NotBlank(message = "Conhecimento do roteiro não pode estar em branco") String conhecimentoRoteiro,
        @NotBlank(message = "Conforto do veículo não pode estar em branco") String confortoVeiculo,
        @NotBlank(message = "Simpatia do motorista não pode estar em branco") String simpatiaMotorista,
        @NotBlank(message = "Experiência geral não pode estar em branco") String experienciaGeral,
        @NotBlank(message = "Adaptabilidade não pode estar em branco") String adaptabilidade,
        @NotBlank(message = "Paradas interessantes não pode estar em branco") String paradasInteressantes,
        @NotBlank(message = "Diferencial não pode estar em branco") String diferencial,
        @NotBlank(message = "Feedback não pode estar em branco") String feedback,
        @NotNull(message = "O avaliadorId é obrigatório") Long avaliadorId,
        @NotNull(message = "O bugueiroId é obrigatório") Long bugueiroId
) {}
