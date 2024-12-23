package br.com.cwi.api.mapper;

import br.com.cwi.api.controller.response.CorridaResponse;
import br.com.cwi.api.domain.Corrida;

public class CorridaMapper {

    public static CorridaResponse toResponse (Corrida entity) {
        return CorridaResponse.builder()
                .id(entity.getId())
                .horarioInicio(entity.getHorarioInicio())
                .status(entity.getStatus().toString())
                .nomeMotorista(entity.getMotorista().getNome())
                .nomePassageiro(entity.getPassageiro().getNome())
                .build();
    }
}
