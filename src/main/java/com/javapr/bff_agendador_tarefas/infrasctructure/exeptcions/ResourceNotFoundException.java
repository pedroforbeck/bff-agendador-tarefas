package com.javapr.bff_agendador_tarefas.infrasctructure.exeptcions;

public class ResourceNotFoundException extends RuntimeException {

    public ResourceNotFoundException(String message) {
        super(message);
    }

    public ResourceNotFoundException(String message, Throwable throwable){
        super(message, throwable);
    }
}
