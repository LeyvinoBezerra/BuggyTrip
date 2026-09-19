package br.edu.ufersa.pw.todo.buggytrip.api.dtos;

import br.edu.ufersa.pw.todo.buggytrip.features.usuario.enume.EnumUsuario;
public record UsuarioPatch(
        String nome,
        String email,
        String senha,
        EnumUsuario tipo
) {
}