package com.javapr.bff_agendador_tarefas.infrasctructure.client.config;

import com.javapr.bff_agendador_tarefas.infrasctructure.exeptcions.BusinessException;
import com.javapr.bff_agendador_tarefas.infrasctructure.exeptcions.ConflictException;
import com.javapr.bff_agendador_tarefas.infrasctructure.exeptcions.ResourceNotFoundException;
import com.javapr.bff_agendador_tarefas.infrasctructure.exeptcions.UnauthorizedException;
import feign.Response;
import feign.codec.ErrorDecoder;
import org.apache.coyote.BadRequestException;

import java.io.IOException;
import java.nio.charset.StandardCharsets;

public class FeignError implements ErrorDecoder {

    @Override
    public Exception decode(String methodKey, Response response) {

        String mensagemErro = "";

        if (response.body() != null) {
            try {

                mensagemErro = new String(response.body().asInputStream().readAllBytes(), StandardCharsets.UTF_8);
            } catch (IOException e) {
                mensagemErro = "Não foi possível extrair a mensagem de erro do servidor.";
            }
        }

        switch (response.status()) {
            case 409:
                return new ConflictException(mensagemErro.isEmpty() ? "Erro atributo já existente" : mensagemErro);
            case 404:
                return new ResourceNotFoundException("Erro atributo não encontrado");
            case 401:
                return new UnauthorizedException("Acesso negado");
            case 400:
                return new BadRequestException("Erro: " + mensagemErro);
            default:
                return new BusinessException("Erro de servidor ao chamar " + methodKey);
        }
    }
}