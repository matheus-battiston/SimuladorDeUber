package br.com.cwi.api.controller.request;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@Getter
@Setter
public class SolicitarCorridaRequest {

    @NotNull(message = "Campo latitude inicial não pode ser nulo")
    @Min(value = -90, message = "Campo latitude inicial tem coordenada invalida")
    @Max(value = 90, message = "Campo latitude inicial tem coordenada invalida")
    private BigDecimal inicioX;

    @NotNull(message = "Campo longitude inicial não pode ser nulo")
    @Min(value = -180, message = "Campo longitude inicial tem coordenada invalida")
    @Max(value = 180, message = "Campo longitude inicial  tem coordenada invalida")
    private BigDecimal inicioY;

    @NotNull(message = "Campo latitude final não pode ser nulo")
    @Min(value = -90, message = "Campo latitude final  tem coordenada invalida")
    @Max(value = 90, message = "Campo latitude final tem coordenada invalida")
    private BigDecimal finalX;

    @NotNull(message = "Campo longitude final não pode ser nulo")
    @Min(value = -180, message = "Campo longitude final tem coordenada invalida")
    @Max(value = 180, message = "Campo longitude final tem coordenada invalida")
    private BigDecimal finalY;
}
