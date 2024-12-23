package br.com.cwi.api.controller.request;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@Getter @Setter
public class SacarMotoristaRequest {

    @NotNull(message = "Valor deve ser preenchido")
    @Min(value = 1, message = "Valor minimo é 1")
    private BigDecimal valorSaque;
}
