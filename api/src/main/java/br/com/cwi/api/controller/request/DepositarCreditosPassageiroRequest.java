package br.com.cwi.api.controller.request;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@Getter
@Setter
public class DepositarCreditosPassageiroRequest {

    @NotNull(message = "Deve ser informado o valor do depósito")
    @DecimalMin(value = "0.01", message = "O deposito deve ser maior que 0")
    private BigDecimal valorDeposito;
}
