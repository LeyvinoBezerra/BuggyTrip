package br.edu.ufersa.pw.todo.buggytrip.api.dtos;

import br.edu.ufersa.pw.todo.buggytrip.api.enume.Estado;

import java.time.LocalDate;


    public record UsuarioDelete(Long id) {
        public  UsuarioDelete{
            if(item==null|| item.isBlank())
                throw  new IllegalArgumentException("o item é obrigatorio");
            if(prazo==null) prazo = LocalDate.now();
            if(estado==null) estado= Estado.EM_ANDAMENTO;
        }
}
