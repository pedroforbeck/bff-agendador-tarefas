package com.javapr.bff_agendador_tarefas.infrasctructure.exeptcions;

public class ConflictException extends RuntimeException {

    public ConflictException(String message){

        super(message);
    }
    public ConflictException(String message, Throwable throwable){
        super(message);
    }

}
