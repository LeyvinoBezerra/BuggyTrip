package br.edu.ufersa.pw.todo.buggytrip.api.dtos;

import br.edu.ufersa.pw.todo.buggytrip.api.enume.EnumUsuario;
import br.edu.ufersa.pw.todo.buggytrip.api.enume.Estado;

import java.time.LocalDate;

import java.time.LocalDate;

public record UsuarioUpdate(
        Long id,
        String nome,
        String email,
        String senha,
        EnumUsuario tipo,
        LocalDate prazo,
        Estado estado
) {
    public UsuarioUpdate {
        if (id == null) {
            throw new IllegalArgumentException("O id é obrigatório!");
        }

        if (nome == null || nome.isBlank()) {
            throw new IllegalArgumentException("O nome é obrigatório!");
        }

        if (email == null || email.isBlank()) {
            throw new IllegalArgumentException("O e-mail é obrigatório!");
        }

        if (senha == null || senha.isBlank()) {
            throw new IllegalArgumentException("A senha é obrigatória!");
        }

        if (tipo == null) {
            tipo = EnumUsuario.AVALIADOR; // valor padrão
        }

        if (prazo == null) {
            throw new IllegalArgumentException("O prazo é obrigatório!");
        }

        if (estado == null) {
            throw new IllegalArgumentException("O estado é obrigatório!");
        }
    }
}
