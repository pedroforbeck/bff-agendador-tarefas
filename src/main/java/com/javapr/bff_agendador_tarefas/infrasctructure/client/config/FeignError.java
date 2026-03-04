package com.javapr.bff_agendador_tarefas.infrasctructure.client.config;

import com.javapr.bff_agendador_tarefas.infrasctructure.exeptcions.BusinessException;
import com.javapr.bff_agendador_tarefas.infrasctructure.exeptcions.ConflictException;
import com.javapr.bff_agendador_tarefas.infrasctructure.exeptcions.ResourceNotFoundException;
import com.javapr.bff_agendador_tarefas.infrasctructure.exeptcions.UnauthorizedException;
import feign.Response;
import feign.codec.ErrorDecoder;

public class FeignError implements ErrorDecoder {


    @Override
    public Exception decode(String s, Response response) {
        switch (response.status()) {
            case 409:
                return new ConflictException("Erro atributo já existente");
                case 403:
                    return new ResourceNotFoundException("Erro atributo não encontrado");
                    case 401:
                        return new UnauthorizedException("Acesso negado");
                        default:
                            return new BusinessException("Erro de servidor");

        }
    }
}
