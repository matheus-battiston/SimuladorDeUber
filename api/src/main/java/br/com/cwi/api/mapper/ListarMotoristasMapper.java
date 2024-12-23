package br.com.cwi.api.mapper;

import br.com.cwi.api.controller.response.ListarMotoristaResponse;
import br.com.cwi.api.domain.Motorista;
import br.com.cwi.api.utils.StatusUtils;

public class ListarMotoristasMapper {

    public static ListarMotoristaResponse toResponse(Motorista entity) {

        return ListarMotoristaResponse.builder()
                .id(entity.getId())
                .nome(entity.getNome())
                .nota(entity.getMediaDasAvaliacoes())
                .status(StatusUtils.calculaStatusMotorista(entity))
                .build();
    }
}
