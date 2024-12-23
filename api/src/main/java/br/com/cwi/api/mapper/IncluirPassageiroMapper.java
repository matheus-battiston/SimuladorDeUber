package br.com.cwi.api.mapper;

import br.com.cwi.api.controller.request.IncluirPassageiroRequest;
import br.com.cwi.api.controller.response.IdResponse;
import br.com.cwi.api.domain.Passageiro;

public class IncluirPassageiroMapper {

    public static Passageiro toEntity(IncluirPassageiroRequest request) {

        return Passageiro.builder()
                .nome(request.getNome())
                .cpf(request.getCpf())
                .dataNascimento(request.getDataNascimento())
                .build();

    }


    public static IdResponse toResponse(Passageiro entity) {

        return IdResponse.builder()
                .id(entity.getId())
                .build();
    }
}
