package br.edu.ufersa.pw.todo.buggytrip.api.dtos;

import java.time.LocalDate;

public record UsuarioUpdate(Long id, String item, LocalDate prazo, Estado estado) {
    public UsuarioUpdate{
        if(id==null)
            throw new IllegalArgumentException("O id é obrigatório!");
        if(item==null|| item.isBlank())
            throw new IllegalArgumentException("O id é obrigatório");
        if(prazo==null) throw new IllegalArgumentException("O prazo é obrigatório!");
        if(estado==null) throw new IllegalArgumentException("O estado é obrigatório!");
    }
}
