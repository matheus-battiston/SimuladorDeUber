package br.com.cwi.api.mapper;

import br.com.cwi.api.controller.response.SaqueMotoristaResponse;
import br.com.cwi.api.domain.Motorista;

public class SaqueMotoristaMapper {
    public static SaqueMotoristaResponse toResponse(Motorista entity){
        return SaqueMotoristaResponse.builder()
                .nome(entity.getNome())
                .saldoAtual(entity.getSaldoEmConta())
                .id(entity.getId())
                .build();
    }
}
