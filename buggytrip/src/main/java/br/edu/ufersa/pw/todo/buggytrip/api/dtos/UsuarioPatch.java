package br.edu.ufersa.pw.todo.buggytrip.api.dtos;

import br.edu.ufersa.pw.todo.buggytrip.api.enume.EnumUsuario;

import java.time.LocalDate;

public record UsuarioPatch(String nome, String email, String senha, EnumUsuario tipo) {
    public  UsuarioPatch{
        if(item==null|| item.isBlank())
            throw  new IllegalArgumentException("o item é obrigatorio");
        if(prazo==null) prazo = LocalDate.now();
        if(estado==null) estado=Estado .EM_ANDAMENTO;
    }
}