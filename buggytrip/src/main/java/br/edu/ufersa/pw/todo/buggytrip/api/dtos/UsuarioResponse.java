package br.edu.ufersa.pw.todo.buggytrip.api.dtos;

import br.edu.ufersa.pw.todo.buggytrip.api.dtos.Estado;

import java.time.LocalDate;

public record UsuarioResponse(Long id, String item, LocalDate prazo, Estado estado) {
    public UsuarioResponse{
        if(id==null)
            throw new IllegalArgumentException("O id é obrigatório!");
        if(item==null|| item.isBlank())
            throw new IllegalArgumentException("O id é obrigatório");
        if(prazo==null) throw new IllegalArgumentException("O prazo é obrigatório!");
        if(estado==null) throw new IllegalArgumentException("O estado é obrigatório!");
    }
}
