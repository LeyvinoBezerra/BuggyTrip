package br.edu.ufersa.pw.todo.buggytrip.domain;

import br.edu.ufersa.pw.todo.buggytrip.domain.entities.Perfil;

import java.util.List;
import java.util.Optional;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING, unmappedTargetPolicy = ReportingPolicy.IGNORE)
    public interface PerfilMapper {

        Perfil toPerfil(PerfilPostRequest request);

        Perfil toPerfil(PerfilPutRequest request);

        <PerfilPostResponse> PerfilPostResponse toPerfilPostResponse(Optional<Perfil> perfil);

        PerfilGetResponse toPerfilGetResponse(Optional<Perfil> perfil);

        PerfilPutResponse toPerfilPutResponse(Optional<Perfil> perfil);

        List<PerfilGetResponse> toPerfilGetResponseList(List<Perfil> perfil);
}
