package br.edu.ufersa.pw.todo.buggytrip.api.dtos.Avaliacao.request;

import java.util.Objects;

public record AvaliacaoPostRequest(
        Integer seguranca,
        Integer conhecimentoRoteiro,
        Integer confortoVeiculo,
        Integer simpatiaMotorista,
        Integer experienciaGeral,
        Integer adaptabilidade,
        Integer paradasInteressantes,
        String diferencial,
        String feedback,
        Long avaliadorId,
        Long bugueiroId
) {
    public AvaliacaoPostRequest {
        // validações básicas
        if (seguranca == null || seguranca < 0 || seguranca > 10) {
            throw new IllegalArgumentException("Segurança deve estar entre 0 e 10");
        }
        if (conhecimentoRoteiro == null || conhecimentoRoteiro < 0 || conhecimentoRoteiro > 10) {
            throw new IllegalArgumentException("Conhecimento do roteiro deve estar entre 0 e 10");
        }
        if (confortoVeiculo == null || confortoVeiculo < 0 || confortoVeiculo > 10) {
            throw new IllegalArgumentException("Conforto do veículo deve estar entre 0 e 10");
        }
        if (simpatiaMotorista == null || simpatiaMotorista < 0 || simpatiaMotorista > 10) {
            throw new IllegalArgumentException("Simpatia do motorista deve estar entre 0 e 10");
        }
        if (experienciaGeral == null || experienciaGeral < 0 || experienciaGeral > 10) {
            throw new IllegalArgumentException("Experiência geral deve estar entre 0 e 10");
        }
        if (adaptabilidade == null || adaptabilidade < 0 || adaptabilidade > 10) {
            throw new IllegalArgumentException("Adaptabilidade deve estar entre 0 e 10");
        }
        if (paradasInteressantes == null || paradasInteressantes < 0 || paradasInteressantes > 10) {
            throw new IllegalArgumentException("Paradas interessantes deve estar entre 0 e 10");
        }

        if (Objects.isNull(avaliadorId)) {
            throw new IllegalArgumentException("O avaliador é obrigatório");
        }
        if (Objects.isNull(bugueiroId)) {
            throw new IllegalArgumentException("O bugueiro é obrigatório");
        }
    }
}

