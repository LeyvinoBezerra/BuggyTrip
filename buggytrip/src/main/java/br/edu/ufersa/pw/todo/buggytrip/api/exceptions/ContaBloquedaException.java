package br.edu.ufersa.pw.todo.buggytrip.api.exceptions;

public class ContaBloquedaException extends DomainException{
    public ContaBloquedaException(String mensagem) {
        super(mensagem);
    }
}
