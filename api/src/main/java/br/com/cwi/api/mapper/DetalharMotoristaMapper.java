package br.com.cwi.api.mapper;

import br.com.cwi.api.controller.response.CorridaResponse;
import br.com.cwi.api.controller.response.DetalharMotoristaResponse;
import br.com.cwi.api.controller.response.VeiculoResponse;
import br.com.cwi.api.domain.Motorista;
import br.com.cwi.api.utils.StatusUtils;

import java.util.List;
import java.util.stream.Collectors;

public class DetalharMotoristaMapper {
    public static DetalharMotoristaResponse toResponse(Motorista entity) {
        VeiculoResponse veiculo = entity.getVeiculo() != null ? VeiculoMapper.toResponse(entity.getVeiculo()) : null;
        List<CorridaResponse> corridas = entity.getCorridas() != null ? entity.getCorridas().stream()
                .map(CorridaMapper::toResponse).collect(Collectors.toList()): null;

        return  DetalharMotoristaResponse.builder()
                .id(entity.getId())
                .nome(entity.getNome())
                .nota(entity.getMediaDasAvaliacoes())
                .status(StatusUtils.calculaStatusMotorista(entity))
                .numeroDeCorridas(entity.getNumeroDeCorridas())
                .saldoEmConta(entity.getSaldoEmConta())
                .habilitacaoNumero(entity.getHabilitacaoNumero())
                .habilitacaoDataVencimento(entity.getHabilitacaoDataVencimento())
                .habilitacaoCategoria(entity.getHabilitacaoCategoria().toString())
                .veiculo(veiculo)
                .corridas(corridas)
                .build();
    }
}
