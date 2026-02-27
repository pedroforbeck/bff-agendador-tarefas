package com.javapr.bff_agendador_tarefas.business;


import com.javapr.bff_agendador_tarefas.business.dto.TarefasDTO;
import com.javapr.bff_agendador_tarefas.business.enums.StatusNotificacaoEnum;
import com.javapr.bff_agendador_tarefas.infrasctructure.client.TarefasClient;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class TarefasService {


    private final TarefasClient tarefasClient;

    public TarefasDTO gravarTarefa(String token, TarefasDTO dto) {
        return tarefasClient.gravarTarefas(dto, token);
    }

    public List<TarefasDTO> buscaTarefasAgendadasPorPeriodo(LocalDateTime dataInicial,
                                                            LocalDateTime dataFinal,
                                                            String token) {

        return tarefasClient.buscaListaDeTarefasPorPeriodo(dataInicial, dataFinal, token);
    }

    public List<TarefasDTO> buscaTarefasPorEmail(String token) {
        return tarefasClient.buscaTarefaPorEmail(token);
    }

    public void deletaTarefaPorId(String id, String token) {
        tarefasClient.deletaTarefaPorId(id, token);

    }

    public TarefasDTO alteraStatus(StatusNotificacaoEnum status, String id, String token) {
        return tarefasClient.alteraStatusNotificacao(status, id, token);
    }


    public TarefasDTO updateTarefas(TarefasDTO dto, String id) {
        try {
            TarefasEntity entity = tarefasRepository.findById(id).
                    orElseThrow(() -> new ResourceNotFoundException("Tarefa não encontrada " + id));
            tarefaUpdateConverter.updateTarefas(dto, entity);
            return tarefaConverter.paraTarefasDTO(tarefasRepository.save(entity));

        } catch (ResourceNotFoundException e) {
            throw new ResourceNotFoundException("Erro ao alteras satus da tarefa " + e.getCause());
        }
    }

}
