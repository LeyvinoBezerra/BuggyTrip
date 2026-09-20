package br.edu.ufersa.pw.todo.buggytrip.api.dtos.Usuario.response;

import br.edu.ufersa.pw.todo.buggytrip.domain.enuns.EnumUsuario;

import java.util.Objects;


public record UsuarioGetResponse(
        Long id,
        String nome,
        String email,
        EnumUsuario tipo
) {
    public UsuarioGetResponse {
        if (Objects.isNull(id)) {
            throw new IllegalArgumentException("O ID do usuário é obrigatório");
        }
        if (nome == null || nome.isBlank()) {
            throw new IllegalArgumentException("O nome do usuário é obrigatório");
        }
        if (email == null || email.isBlank()) {
            throw new IllegalArgumentException("O email do usuário é obrigatório");
        }
        if (Objects.isNull(tipo)) {
            throw new IllegalArgumentException("O tipo de usuário é obrigatório");
        }
    }
}
