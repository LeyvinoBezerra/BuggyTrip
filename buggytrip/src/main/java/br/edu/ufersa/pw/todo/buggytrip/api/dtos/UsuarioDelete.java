package br.edu.ufersa.pw.todo.buggytrip.api.dtos;

import br.edu.ufersa.pw.todo.buggytrip.api.enume.EnumUsuario;
import br.edu.ufersa.pw.todo.buggytrip.api.enume.Estado;

import java.time.LocalDate;


public record UsuarioDelete(
        String nome,
        String email,
        String senha,
        EnumUsuario tipo,
        LocalDate prazo,
        Estado estado
) {
    public UsuarioDelete {
        if (nome == null || nome.isBlank()) {
            throw new IllegalArgumentException("O nome é obrigatório");
        }

        if (email == null || email.isBlank()) {
            throw new IllegalArgumentException("O e-mail é obrigatório");
        }

        if (senha == null || senha.isBlank()) {
            throw new IllegalArgumentException("A senha é obrigatória");
        }

        if (tipo == null) {
            tipo = EnumUsuario.AVALIADOR; // valor padrão
        }

        if (prazo == null) {
            prazo = LocalDate.now(); // data atual como padrão
        }

        if (estado == null) {
            estado = Estado.EM_ANDAMENTO; // estado inicial padrão
        }
    }
}
