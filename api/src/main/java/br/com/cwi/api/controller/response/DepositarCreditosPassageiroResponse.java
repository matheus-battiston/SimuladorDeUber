package br.com.cwi.api.controller.response;

import lombok.*;

import java.math.BigDecimal;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class DepositarCreditosPassageiroResponse {

    private Long id;
    private String nome;
    private BigDecimal saldoAtual;
}
