package br.com.cwi.api.validator;

import org.springframework.stereotype.Component;
import org.springframework.web.server.ResponseStatusException;

import java.math.BigDecimal;

import static org.springframework.http.HttpStatus.BAD_REQUEST;

@Component
public class ValidarDepositoPassageiro {

    private static final String VALOR_DEPOSITADO_DEVE_SER_MAIOR_QUE_ZERO = "O valor depositado deve ser maior que zero";


    public void validarValorMaiorQueZero(BigDecimal valorDeposito) {
        if(valorDeposito.compareTo(BigDecimal.ZERO) <= 0) {
            throw new ResponseStatusException(BAD_REQUEST, VALOR_DEPOSITADO_DEVE_SER_MAIOR_QUE_ZERO);
        }
    }
}
