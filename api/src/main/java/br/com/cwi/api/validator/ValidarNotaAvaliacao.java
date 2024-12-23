package br.com.cwi.api.validator;

import org.springframework.stereotype.Component;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;

import static org.springframework.http.HttpStatus.BAD_REQUEST;

@Component
public class ValidarNotaAvaliacao {

    private static final String NOTA_INVALIDA = "O valor de nota informado não é válido. São aceitos valores inteiros de 1 a 5.";

    public void validarNota(int nota) {

        List<Integer> listaDeNotasValidas = new ArrayList<>();
        listaDeNotasValidas.add(1);
        listaDeNotasValidas.add(2);
        listaDeNotasValidas.add(3);
        listaDeNotasValidas.add(4);
        listaDeNotasValidas.add(5);

        if(!listaDeNotasValidas.contains(nota)) {
            throw new ResponseStatusException(BAD_REQUEST, NOTA_INVALIDA);
        }
    }
}
