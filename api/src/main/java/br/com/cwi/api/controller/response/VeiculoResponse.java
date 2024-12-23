package br.com.cwi.api.controller.response;

import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class VeiculoResponse {

    private String placa;
    private String modelo;
    private String cor;
    private String fotoUrl;
}
