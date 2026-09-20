package br.edu.ufersa.pw.todo.buggytrip.api.dtos.Avaliacao.response;




import java.util.Objects;

public record AvaliacaoPostResponse(
        Long id,
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
    public AvaliacaoPostResponse {
        if (Objects.isNull(id)) {
            throw new IllegalArgumentException("O ID da avaliação é obrigatório após criação");
        }
        if (Objects.isNull(avaliadorId)) {
            throw new IllegalArgumentException("O avaliador é obrigatório");
        }
        if (Objects.isNull(bugueiroId)) {
            throw new IllegalArgumentException("O bugueiro é obrigatório");
        }
    }
}
