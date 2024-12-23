package br.com.cwi.api.mapper;

import br.com.cwi.api.controller.response.CorridaResponse;
import br.com.cwi.api.controller.response.DetalharPassageiroResponse;
import br.com.cwi.api.domain.Passageiro;
import br.com.cwi.api.utils.StatusUtils;

import java.util.List;
import java.util.stream.Collectors;

public class DetalharPassageiroMapper {
    public static DetalharPassageiroResponse toResponse(Passageiro entity) {
        List<CorridaResponse> corridas = entity.getCorridas() != null ? entity.getCorridas().stream()
                .map(CorridaMapper::toResponse).collect(Collectors.toList()): null;

        return  DetalharPassageiroResponse.builder()
                .id(entity.getId())
                .nome(entity.getNome())
                .nota(entity.getMediaDasAvaliacoes())
                .status(StatusUtils.calculaStatusPassageiro(entity))
                .numeroDeCorridas(entity.getNumeroDeCorridas())
                .saldoEmConta(entity.getSaldoEmConta())
                .corridas(corridas)
                .build();
    }
}
