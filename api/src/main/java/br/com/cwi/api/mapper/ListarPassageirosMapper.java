package br.com.cwi.api.mapper;

import br.com.cwi.api.controller.response.ListarPassageiroResponse;
import br.com.cwi.api.domain.Passageiro;
import br.com.cwi.api.utils.StatusUtils;

public class ListarPassageirosMapper {

    public static ListarPassageiroResponse toResponse(Passageiro entity) {


        return ListarPassageiroResponse.builder()
                .id(entity.getId())
                .nome(entity.getNome())
                .nota(entity.getMediaDasAvaliacoes())
                .status(StatusUtils.calculaStatusPassageiro(entity))
                .build();
    }
}
