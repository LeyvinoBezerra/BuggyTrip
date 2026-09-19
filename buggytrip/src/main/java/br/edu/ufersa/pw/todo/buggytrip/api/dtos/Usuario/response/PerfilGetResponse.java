package br.edu.ufersa.pw.todo.buggytrip.api.dtos.Usuario.response;

import lombok.*;

import java.time.LocalDateTime;


    @Getter
    @Setter
    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    public class UsuarioGetResponse {

        private Long id;

        private PessoaGetResponse pessoa;

        private String email;

        private LocalDateTime dataCriacao;

        private LocalDateTime dataAtualizacao;

        private Integer numeroVersao;
    }

