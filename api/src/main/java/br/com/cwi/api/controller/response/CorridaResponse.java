package br.com.cwi.api.controller.response;

import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CorridaResponse {

    private Long id;
    private LocalDateTime horarioInicio;
    private String status;
    private String nomeMotorista;
    private String nomePassageiro;
}