package br.edu.ufersa.pw.todo.buggytrip.api.dtos;

public class PerfilGetResponse {

    @Getter
    @Setter
    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    public class UsuarioGetResponse {

        private Long id;

        private PessoaGetResponse pessoa;

        private String email;

        private LocalDate dataAdmissao;

        private LocalDate dataDemissao;

        private StatusEnum status;

        private String tipoContrato;

        private BigDecimal salarioBase;

        private LocalDateTime dataCriacao;

        private LocalDateTime dataAtualizacao;

        private Integer numeroVersao;
    }
}
