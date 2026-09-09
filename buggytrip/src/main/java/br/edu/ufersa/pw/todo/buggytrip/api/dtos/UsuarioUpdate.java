package br.edu.ufersa.pw.todo.buggytrip.api.dtos;

import br.edu.ufersa.pw.todo.buggytrip.api.enume.EnumUsuario;

import java.time.LocalDate;

public record UsuarioUpdate(String nome, String email, String senha, EnumUsuario tipo) {
    public UsuarioUpdate{
        if(id==null)
            throw new IllegalArgumentException("O id é obrigatório!");
        if(item==null|| item.isBlank())
            throw new IllegalArgumentException("O id é obrigatório");
        if(prazo==null) throw new IllegalArgumentException("O prazo é obrigatório!");
        if(estado==null) throw new IllegalArgumentException("O estado é obrigatório!");
    }
}
