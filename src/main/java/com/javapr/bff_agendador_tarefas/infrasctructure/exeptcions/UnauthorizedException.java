package com.javapr.bff_agendador_tarefas.infrasctructure.exeptcions;

public class UnauthorizedException extends RuntimeException {
    public UnauthorizedException(String message) {
        super(message);
    }
}
