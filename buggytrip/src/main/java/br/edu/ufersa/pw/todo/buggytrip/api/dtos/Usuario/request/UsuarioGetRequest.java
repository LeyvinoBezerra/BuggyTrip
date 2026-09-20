package br.edu.ufersa.pw.todo.buggytrip.api.dtos.Usuario.request;

import java.util.Objects;


public record UsuarioGetRequest(
        Long id,
        String nome,
        String email

) {
    public UsuarioGetRequest {
        if (Objects.isNull(id)) {
            throw new IllegalArgumentException("O ID do usuário é obrigatório para consulta");
        }
    }
}
