package br.edu.ufersa.pw.todo.buggytrip.api.dtos;

import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class PerfilPutResponse {

    @Getter
    @Setter
    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    public class UsuarioGetResponse {

        private Long id;

        private UsuarioGetResponse pessoa;

        private String email;

        private LocalDateTime dataCriacao;

        private LocalDateTime dataAtualizacao;

        private Integer numeroVersao;
    }
}
