package br.com.cwi.api.controller.response;

import lombok.*;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class SolicitarCorridaResponse {

    private Long corridaId;
    private String nomeMotorista;
    private VeiculoResponse veiculo;
    private String tempoEstimadoChegada;
}