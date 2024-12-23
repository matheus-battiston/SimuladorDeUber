package br.com.cwi.api.controller.request;

import br.com.cwi.api.domain.Categoria;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.URL;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Getter
@Setter

public class IncluirVeiculoRequest {

    @NotBlank(message = "Placa deve ser preenchida")
    @Size(min = 7, max = 7, message = "Placa deve ter 7 caracteres")
    private String placa;

    @NotBlank(message = "Modelo deve ser preenchido")
    private String modelo;

    @NotBlank(message = "Cor deve ser preenchido")
    private String cor;

    @URL(message = "URL invalida")
    @NotBlank(message = "URL da foto deve ser preenchido")
    private String fotoUrl;

    @NotNull(message = "Id do proprietario não informado")
    private Long proprietarioId;

    @NotNull(message = "Categoria deve ser preenchida")
    private Categoria categoria;

}
