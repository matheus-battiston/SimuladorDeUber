package br.com.cwi.api.mapper;

import br.com.cwi.api.controller.request.IncluirMotoristaRequest;
import br.com.cwi.api.controller.response.IdResponse;
import br.com.cwi.api.domain.Motorista;

public class IncluirMotoristaMapper {
    public static Motorista toEntity(IncluirMotoristaRequest request){

        return Motorista.builder()
                .cpf(request.getCpf())
                .dataNascimento(request.getDataNascimento())
                .nome(request.getNome())
                .habilitacaoCategoria(request.getHabilitacaoCategoria())
                .habilitacaoDataVencimento(request.getHabilitacaoDataVencimento())
                .habilitacaoNumero(request.getHabilitacaoNumero())
                .build();
    }

    public static IdResponse toResponse(Motorista motorista) {
        return IdResponse.builder()
                .id(motorista.getId())
                .build();
    }
}
