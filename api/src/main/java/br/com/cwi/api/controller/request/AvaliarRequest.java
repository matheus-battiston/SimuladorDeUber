package br.com.cwi.api.controller.request;

import lombok.*;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AvaliarRequest {

    @NotNull(message = "Campo nota é obrigatório")
    @Min(value = 1, message = "Nota minima é 1")
    @Max(value = 5, message = "Nota maxima  é 5")
    private int nota;

    @NotNull(message = "Campo id da corrida é obrigatório")
    private Long idDaCorrida;
}
