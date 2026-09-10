package br.edu.ufersa.pw.todo.buggytrip.api.dtos;

import br.edu.ufersa.pw.todo.buggytrip.api.enume.EnumUsuario;
import br.edu.ufersa.pw.todo.buggytrip.api.enume.Estado;

import java.time.LocalDate;

import static br.edu.ufersa.pw.todo.buggytrip.api.enume.EnumUsuario.AVALIADOR;

public record UsuarioCreate(String nome, String email, String senha, EnumUsuario tipo) {
    public UsuarioCreate {
        if (nome == null || nome.isBlank()) {
            throw new IllegalArgumentException("O nome é obrigatório");
        }

        if (email == null || email.isBlank()) {
            email = String.valueOf(LocalDate.now());
        }

        if (senha == null || senha.isBlank()) {
            senha = email;
        }

        if (tipo == null) {
            tipo = EnumUsuario.AVALIADOR;
        }
    }
}