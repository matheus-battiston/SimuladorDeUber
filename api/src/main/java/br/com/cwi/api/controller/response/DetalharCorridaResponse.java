package br.com.cwi.api.controller.response;

import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class DetalharCorridaResponse {
    private Long id;
    private LocalDateTime horarioInicio;
    private String status;
    private String nomeMotorista;
    private Long idMotorista;
    private String nomePassageiro;
    private Long idPassageiro;
    private BigDecimal inicioX;
    private BigDecimal inicioY;
    private BigDecimal finalX;
    private BigDecimal finalY;
    private LocalDateTime horarioChegada;
    private BigDecimal valorEstimado;
    private BigDecimal valorTotal;
    private Integer notaMotorista;
    private Integer notaPassageiro;
    private BigDecimal distancia;
}
