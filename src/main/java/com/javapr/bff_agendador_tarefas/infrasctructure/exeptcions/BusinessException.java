package com.javapr.bff_agendador_tarefas.infrasctructure.exeptcions;

public class BusinessException extends RuntimeException {
    public BusinessException(String message) {
        super(message);
    }

}
