package br.edu.ufersa.pw.todo.buggytrip.domain.entities;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDate;
import java.time.LocalDateTime;


    @Getter
    @Setter
    @AllArgsConstructor
    @NoArgsConstructor
    @EqualsAndHashCode
    @Builder
    @Entity
    @Table(schema = "bt", name = "pessoas")
    @EntityListeners(AuditingEntityListener.class)

    public class Pessoa {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name = "pes_id")
        private Long id;

        @Column(name = "pes_cpf", nullable = false, unique = true, length = 11)
        private String cpf;

        @Column(name = "pes_nome_completo", nullable = false, length = 128)
        private String nomeCompleto;

        @Column(name = "pes_data_nascimento", nullable = false)
        private LocalDate dataNascimento;

        @CreationTimestamp
        @Column(name = "pes_data_criacao", nullable = false)
        private LocalDateTime dataCriacao;

        @UpdateTimestamp
        @Column(name = "pes_data_atualizacao", nullable = false)
        private LocalDateTime dataAtualizacao;

        @Version
        @Column(name = "pes_versao")
        private Integer numeroVersao;
}
