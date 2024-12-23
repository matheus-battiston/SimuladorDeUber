package br.com.cwi.api.controller.response;


import lombok.*;

import java.math.BigDecimal;

@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SaqueMotoristaResponse {

    private String nome;
    private Long id;
    private BigDecimal saldoAtual;
}
