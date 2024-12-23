package br.com.cwi.api.mapper;

import br.com.cwi.api.controller.response.VeiculoResponse;
import br.com.cwi.api.domain.Veiculo;

public class VeiculoMapper {

    public static VeiculoResponse toResponse (Veiculo entity) {
        return VeiculoResponse.builder()
                .modelo(entity.getModelo())
                .placa(entity.getPlaca())
                .cor(entity.getCor())
                .fotoUrl(entity.getFotoUrl())
                .build();
    }
}
