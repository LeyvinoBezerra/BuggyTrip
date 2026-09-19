package br.edu.ufersa.pw.todo.buggytrip.domain.entities;

public enum PermissaoEnum {
    ADMIN,      // Acesso total ao sistema
    BUGUEIRO,   // Quem é avaliado (condutor)
    CLIENTE,    // Quem faz a avaliação
    VISITANTE  // Usuário não cadastrado como cliente no sistema
}
