package br.com.cwi.api.validator;

import org.springframework.stereotype.Component;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDate;

import static java.time.LocalDate.now;
import static java.time.Period.between;
import static org.springframework.http.HttpStatus.BAD_REQUEST;

@Component
public class ValidarMotoristaIdade {
    private static final String USUARIO_MENOR_DE_IDADE = "Pessoa não tem idade minima de 18 anos";
    public void validar(LocalDate dataNascimento){
        LocalDate hoje = now();

        if (between(dataNascimento, hoje).getYears() < 18) {
            throw new ResponseStatusException(BAD_REQUEST, USUARIO_MENOR_DE_IDADE);
        }
    }
}
