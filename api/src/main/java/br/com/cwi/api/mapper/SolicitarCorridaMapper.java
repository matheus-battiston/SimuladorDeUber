package br.com.cwi.api.mapper;

import br.com.cwi.api.controller.request.SolicitarCorridaRequest;
import br.com.cwi.api.controller.response.SolicitarCorridaResponse;
import br.com.cwi.api.domain.Corrida;

public class SolicitarCorridaMapper {
    public static Corrida toEntity(SolicitarCorridaRequest request) {

        return Corrida.builder()
                .inicioX(request.getInicioX())
                .inicioY(request.getInicioY())
                .finalX(request.getFinalX())
                .finalY(request.getFinalY())
                .build();
    }

    public static SolicitarCorridaResponse toResponse(Corrida entity) {

        return SolicitarCorridaResponse.builder()
                .corridaId(entity.getId())
                .nomeMotorista(entity.getMotorista().getNome())
                .veiculo(VeiculoMapper.toResponse(entity.getMotorista().getVeiculo()))
                .build();
    }
}
