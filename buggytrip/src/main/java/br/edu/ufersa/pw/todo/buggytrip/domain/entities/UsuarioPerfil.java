package br.edu.ufersa.pw.todo.buggytrip.domain.entities;

import br.edu.ufersa.pw.todo.buggytrip.domain.enuns.EnumUsuario;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@ToString
@Entity
@Table(schema = "bt", name = "usuarios_perfis")
@EntityListeners(AuditingEntityListener.class)
public class UsuarioPerfil {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "up_id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "up_usu_id", referencedColumnName = "usu_id", nullable = false)
    private Usuario usuario;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "up_per_id", referencedColumnName = "per_id", nullable = false)
    private Perfil perfil;

    @Enumerated(EnumType.STRING)
    @Column(name = "up_tipo_usuario", nullable = false, length = 20)
    private EnumUsuario tipoUsuario; // atributo padrão tipo de usuário

    @CreationTimestamp
    @Column(name = "up_data_criacao", nullable = false)
    private LocalDateTime dataCriacao;

    @UpdateTimestamp
    @Column(name = "up_data_atualizacao", nullable = false)
    private LocalDateTime dataAtualizacao;

    @Version
    @Column(name = "up_versao", nullable = false)
    private Integer numeroVersao;
}
