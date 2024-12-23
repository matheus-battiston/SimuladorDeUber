package br.com.cwi.api.mapper;

import br.com.cwi.api.controller.response.DepositarCreditosPassageiroResponse;
import br.com.cwi.api.domain.Passageiro;

public class DepositarCreditosPassageiroMapper {

    public static DepositarCreditosPassageiroResponse toResponse(Passageiro entity) {

        return DepositarCreditosPassageiroResponse.builder()
                .id(entity.getId())
                .nome(entity.getNome())
                .saldoAtual(entity.getSaldoEmConta())
                .build();
    }
}
