package br.edu.ufersa.pw.todo.buggytrip.api.dtos.Usuario.request;

import java.util.Objects;

import br.edu.ufersa.pw.todo.buggytrip.domain.enuns.EnumUsuario;

public record UsuarioPostRequest(
        String nome,
        String email,
        String senha,
        EnumUsuario tipo
) {
    public UsuarioPostRequest {
        if (nome == null || nome.isBlank()) {
            throw new IllegalArgumentException("O nome é obrigatório");
        }
        if (email == null || email.isBlank()) {
            throw new IllegalArgumentException("O email é obrigatório");
        }
        if (senha == null || senha.isBlank()) {
            throw new IllegalArgumentException("A senha é obrigatória");
        }
        if (Objects.isNull(tipo)) {
            throw new IllegalArgumentException("O tipo de usuário é obrigatório");
        }
    }
}


