package br.edu.ufersa.pw.todo.buggytrip.domain.entities;

import br.edu.ufersa.pw.todo.buggytrip.domain.enuns.EnumUsuario;
import jakarta.persistence.*;
import lombok.*;


@Getter
@Setter
@Builder
@Data
@Entity
@Table(schema = "bt", name = "usuarios")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "usu_id")
    private Long id;

    @Column(name = "usu_nome", nullable = false, length = 100)
    private String nome;

    @Column(name = "usu_email", nullable = false, unique = true, length = 150)
    private String email;

    @Column(name = "usu_senha", nullable = false, length = 255)
    private String senha;

    @Enumerated(EnumType.STRING)
    @Column(name = "usu_tipo", nullable = false, length = 20)
    private EnumUsuario usuarioTipo; // "AVALIADOR", "BUGUEIRO", "ADM"


}
