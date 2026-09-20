package br.edu.ufersa.pw.todo.buggytrip.domain.entities;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

@Data
@Entity
@Table(schema = "bt", name = "bugueiros")
@EntityListeners(AuditingEntityListener.class)
public class Bugueiro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "bug_id")
    private Long id;

    @Column(name = "bug_nome", nullable = false, length = 100)
    private String nome;

    @Column(name = "bug_email", nullable = false, unique = true, length = 150)
    private String email;

    @Column(name = "bug_telefone", length = 20)
    private String telefone;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "bug_perfil_id", referencedColumnName = "per_id", nullable = false)
    private Perfil perfil; // vínculo com perfil (tipo BUGUEIRO)

    @CreationTimestamp
    @Column(name = "bug_data_criacao", nullable = false)
    private LocalDateTime dataCriacao;

    @UpdateTimestamp
    @Column(name = "bug_data_atualizacao", nullable = false)
    private LocalDateTime dataAtualizacao;

    @Version
    @Column(name = "bug_versao", nullable = false)
    private Integer numeroVersao;
}
