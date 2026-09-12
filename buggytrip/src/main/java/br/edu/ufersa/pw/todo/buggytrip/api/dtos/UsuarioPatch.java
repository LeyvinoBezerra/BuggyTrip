package br.edu.ufersa.pw.todo.buggytrip.api.dtos;

import br.edu.ufersa.pw.todo.buggytrip.api.enume.EnumUsuario;
public record UsuarioPatch(
        String nome,
        String email,
        String senha,
        EnumUsuario tipo
) {
}