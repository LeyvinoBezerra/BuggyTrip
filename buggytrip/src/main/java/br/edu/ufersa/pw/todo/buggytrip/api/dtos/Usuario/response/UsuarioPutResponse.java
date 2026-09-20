package br.edu.ufersa.pw.todo.buggytrip.api.dtos.Usuario.response;

import br.edu.ufersa.pw.todo.buggytrip.domain.enuns.EnumUsuario;

import java.util.Objects;


public record UsuarioPutResponse(
        Long id,
        String nome,
        String email,
        EnumUsuario tipo
) {
    public UsuarioPutResponse {
        if (Objects.isNull(id)) {
            throw new IllegalArgumentException("O ID do usuário é obrigatório após atualização");
        }
    }
}
