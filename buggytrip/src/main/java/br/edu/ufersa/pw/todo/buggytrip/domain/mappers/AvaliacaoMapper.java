package br.edu.ufersa.pw.todo.buggytrip.domain.mappers;

import br.edu.ufersa.pw.todo.buggytrip.api.dtos.Avaliacao.request.AvaliacaoPostRequest;
import br.edu.ufersa.pw.todo.buggytrip.api.dtos.Avaliacao.response.AvaliacaoGetResponse;
import br.edu.ufersa.pw.todo.buggytrip.api.dtos.Avaliacao.response.AvaliacaoPostResponse;
import br.edu.ufersa.pw.todo.buggytrip.domain.entities.Avaliacao;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import org.mapstruct.ReportingPolicy;

import java.util.List;
import java.util.Optional;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING, unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface AvaliacaoMapper {

    Avaliacao toAvaliacao(AvaliacaoPostRequest request);

    AvaliacaoPostResponse toAvaliacaoPostResponse(Avaliacao avaliacao);

    AvaliacaoGetResponse toAvaliacaoGetResponse(Avaliacao avaliacao);

    AvaliacaoGetResponse toAvaliacaoGetResponse(Optional<Avaliacao> avaliacao);

    List<AvaliacaoGetResponse> toAvaliacaoGetResponseList(List<Avaliacao> avaliacoes);
}
