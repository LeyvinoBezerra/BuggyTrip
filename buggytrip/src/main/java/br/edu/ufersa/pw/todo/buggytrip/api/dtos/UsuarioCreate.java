package br.edu.ufersa.pw.todo.buggytrip.api.dtos;

import br.edu.ufersa.pw.todo.buggytrip.api.enume.EnumUsuario;
import br.edu.ufersa.pw.todo.buggytrip.api.enume.Estado;

import java.time.LocalDate;

public record UsuarioCreate(String nome, String email, String senha, EnumUsuario tipo) {
    public  UsuarioCreate{
        if(item==null|| item.isBlank())
            throw  new IllegalArgumentException("o item é obrigatorio");
        if(prazo==null) prazo = LocalDate.now();
        if(estado==null) estado= Estado.EM_ANDAMENTO;
    }
}
