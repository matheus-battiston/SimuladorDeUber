package br.com.cwi.api.mapper;

import br.com.cwi.api.controller.response.IniciarCorridaMotoristaResponse;

import java.math.BigDecimal;

public class IniciarCorridaMotoristaMapper {
    public static IniciarCorridaMotoristaResponse toResponse(int tempoEmSegundos, BigDecimal valorEstimadoCorrida) {
        return IniciarCorridaMotoristaResponse.builder()
                .tempoEstimado(tempoEmSegundos)
                .valorEstimado(valorEstimadoCorrida)
                .build();
    }
}
