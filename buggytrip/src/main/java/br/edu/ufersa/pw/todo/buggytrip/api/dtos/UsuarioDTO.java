package br.edu.ufersa.pw.todo.buggytrip.api.dtos;

import lombok.Data;

@Data
public class UsuarioDTO {
    private String nome;
    private String email;
    private String senha;
    private String tipo;
}
