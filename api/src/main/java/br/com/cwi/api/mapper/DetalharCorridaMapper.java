package br.com.cwi.api.mapper;

import br.com.cwi.api.controller.response.DetalharCorridaResponse;
import br.com.cwi.api.domain.Corrida;

public class DetalharCorridaMapper {

    public static DetalharCorridaResponse toResponse (Corrida entity) {
        return DetalharCorridaResponse.builder()
                .id(entity.getId())
                .horarioInicio(entity.getHorarioInicio())
                .status(entity.getStatus().toString())
                .nomeMotorista(entity.getMotorista().getNome())
                .idMotorista(entity.getMotorista().getId())
                .nomePassageiro(entity.getPassageiro().getNome())
                .idPassageiro(entity.getPassageiro().getId())
                .inicioX(entity.getInicioX())
                .inicioY(entity.getInicioY())
                .finalX(entity.getFinalX())
                .finalY(entity.getFinalY())
                .horarioChegada(entity.getHorarioChegada())
                .valorEstimado(entity.getValorEstimado())
                .valorTotal(entity.getValorTotal())
                .notaMotorista(entity.getNotaMotorista())
                .notaPassageiro(entity.getNotaPassageiro())
                .distancia(entity.calcularDistancia())
                .build();
    }
}
