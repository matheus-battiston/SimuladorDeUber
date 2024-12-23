package br.com.cwi.api.mapper;

import br.com.cwi.api.controller.request.IncluirVeiculoRequest;
import br.com.cwi.api.controller.response.IdResponse;
import br.com.cwi.api.domain.Veiculo;

public class IncluirVeiculoMapper {
    public static Veiculo toEntity(IncluirVeiculoRequest request) {
        return Veiculo.builder()
                .categoria(request.getCategoria())
                .cor(request.getCor())
                .fotoUrl(request.getFotoUrl())
                .modelo(request.getModelo())
                .placa(request.getPlaca())
                .build();
    }

    public static IdResponse toResponse(Veiculo veiculo) {
        return IdResponse.builder()
                .id(veiculo.getId())
                .build();
    }
}
