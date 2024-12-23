package br.com.cwi.api.controller.response;

import lombok.*;

import java.math.BigDecimal;
import java.util.List;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class DetalharPassageiroResponse {
    private Long id;
    private String nome;
    private String status;
    private double nota;
    private Integer numeroDeCorridas;
    private BigDecimal saldoEmConta;
    private List<CorridaResponse> corridas;
}
