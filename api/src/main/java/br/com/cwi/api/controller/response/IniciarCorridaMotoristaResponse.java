package br.com.cwi.api.controller.response;


import lombok.*;

import java.math.BigDecimal;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class IniciarCorridaMotoristaResponse {
    Integer tempoEstimado;
    BigDecimal valorEstimado;
}
