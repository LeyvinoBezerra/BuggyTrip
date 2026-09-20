package br.edu.ufersa.pw.todo.buggytrip.domain.mappers;

import br.edu.ufersa.pw.todo.buggytrip.api.dtos.Usuario.request.UsuarioPostRequest;
import br.edu.ufersa.pw.todo.buggytrip.api.dtos.Usuario.request.UsuarioPutRequest;
import br.edu.ufersa.pw.todo.buggytrip.api.dtos.Usuario.response.UsuarioGetResponse;
import br.edu.ufersa.pw.todo.buggytrip.api.dtos.Usuario.response.UsuarioPostResponse;
import br.edu.ufersa.pw.todo.buggytrip.api.dtos.Usuario.response.UsuarioPutResponse;
import br.edu.ufersa.pw.todo.buggytrip.domain.entities.Usuario;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import org.mapstruct.ReportingPolicy;

import java.util.List;
import java.util.Optional;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING, unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface UsuarioMapper {

    Usuario toUsuario(UsuarioPostRequest request);

    UsuarioPostResponse toUsuarioPostResponse(Usuario usuario);

    UsuarioPutResponse toUsuarioPutResponse(Usuario usuario);

    UsuarioGetResponse toUsuarioGetResponse(Usuario usuario);

    UsuarioGetResponse toUsuarioGetResponse(Optional<Usuario> usuario);

    List<UsuarioGetResponse> toUsuarioGetResponseList(List<Usuario> usuarios);
}
