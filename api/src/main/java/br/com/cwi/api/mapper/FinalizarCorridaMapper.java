package br.com.cwi.api.mapper;

import br.com.cwi.api.controller.response.FinalizarCorridaResponse;
import br.com.cwi.api.domain.Corrida;

public class FinalizarCorridaMapper {
    public static FinalizarCorridaResponse toResponse(Corrida corrida) {
        return FinalizarCorridaResponse.builder()
                .valorDaCorrida(corrida.getValorTotal())
                .build();
    }
}
