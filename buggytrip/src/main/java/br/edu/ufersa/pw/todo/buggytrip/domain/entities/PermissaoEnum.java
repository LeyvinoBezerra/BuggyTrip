package br.edu.ufersa.pw.todo.buggytrip.domain.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table
public class PermissaoEnum {

    //TODO [Reverse Engineering] generate columns from DB
    // Permissões de acesso gestao de usuários e perfis
    GERENCIAR_USUARIOS("Gerenciar Usuários"),
    GERENCIAR_PERFIS("Gerenciar Perfis"),

    // Permissões de acesso gestão de relatórios
    GERENCIAR_RELATORIOS("Gerenciar Relatórios"),

    // Permissões de acesso gestão de configurações
    GERENCIAR_CONFIGURACOES("Gerenciar Configurações"),

    // Permissões de acesso gestão de auditoria
    GERENCIAR_AUDITORIA("Gerenciar Auditoria"),

    // Permissões de acesso gestão de integrações
    GERENCIAR_INTEGRACOES("Gerenciar Integrações");

    private String descricao;

}