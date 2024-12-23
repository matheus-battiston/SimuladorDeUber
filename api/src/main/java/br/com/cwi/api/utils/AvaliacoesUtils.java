package br.com.cwi.api.utils;

import org.springframework.web.server.ResponseStatusException;

import static org.springframework.http.HttpStatus.BAD_REQUEST;

public class AvaliacoesUtils {

    private static final String NAO_FOI_POSSIVEL_CALCULAR_A_MEDIA = "Não foi possível calcular a média.";

    public static double calcularMedia(Integer somaDasNotas, Integer quantidadeDeAvaliacoes) {

        if(quantidadeDeAvaliacoes == 0) {
            throw new ResponseStatusException(BAD_REQUEST,NAO_FOI_POSSIVEL_CALCULAR_A_MEDIA);
        } else {
            return (double) somaDasNotas/quantidadeDeAvaliacoes;
        }

    }
}
