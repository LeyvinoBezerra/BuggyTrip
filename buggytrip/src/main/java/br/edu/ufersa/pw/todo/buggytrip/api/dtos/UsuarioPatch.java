package br.edu.ufersa.pw.todo.buggytrip.api.dtos;

import java.time.LocalDate;

public record UsuarioPatch(String item, LocalDate prazo, Estado estado) {
    public  UsuarioPatch{
        if(item==null|| item.isBlank())
            throw  new IllegalArgumentException("o item é obrigatorio");
        if(prazo==null) prazo = LocalDate.now();
        if(estado==null) estado=Estado .EM_ANDAMENTO;
    }
}