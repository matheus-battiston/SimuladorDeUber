package br.com.cwi.api.controller.response;

import lombok.*;

import java.math.BigDecimal;

@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class FinalizarCorridaResponse {
    private BigDecimal valorDaCorrida;
}
