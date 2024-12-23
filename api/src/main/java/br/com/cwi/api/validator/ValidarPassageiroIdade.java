package br.com.cwi.api.validator;

import org.springframework.stereotype.Component;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDate;

import static java.time.LocalDate.now;
import static java.time.Period.between;
import static org.springframework.http.HttpStatus.BAD_REQUEST;

@Component
public class ValidarPassageiroIdade {

    private static final String PASSAGEIRO_LIMITE_IDADE = "Passageiro deve possuir mais de 16 anos";

    public void validar(LocalDate dataNascimento) {

        LocalDate hoje = now();

        if (between(dataNascimento, hoje).getYears() < 16) {
            throw new ResponseStatusException(BAD_REQUEST, PASSAGEIRO_LIMITE_IDADE);
        }
    }
}

