package br.com.cwi.api.controller.response;

import lombok.*;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ListarPassageiroResponse {

    private Long id;
    private String nome;
    private String status;
    private double nota;
}
