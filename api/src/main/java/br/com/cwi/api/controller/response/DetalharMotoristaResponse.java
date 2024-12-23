package br.com.cwi.api.controller.response;

import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class DetalharMotoristaResponse {

    private Long id;
    private String nome;
    private String status;
    private double nota;
    private Integer numeroDeCorridas;
    private BigDecimal saldoEmConta;
    private String habilitacaoNumero;
    private LocalDate habilitacaoDataVencimento;
    private String habilitacaoCategoria;
    private VeiculoResponse veiculo;
    private List<CorridaResponse> corridas;
}
