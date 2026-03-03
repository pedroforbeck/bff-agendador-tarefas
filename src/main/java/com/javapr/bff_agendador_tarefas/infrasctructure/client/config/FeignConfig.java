package com.javapr.bff_agendador_tarefas.infrasctructure.client.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FeignConfig {

    @Bean
    public FeignError feingError(){
        return new FeignError();
    }

}
