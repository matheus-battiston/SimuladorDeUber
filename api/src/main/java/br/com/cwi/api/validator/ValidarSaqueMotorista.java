package br.com.cwi.api.validator;

import br.com.cwi.api.domain.Motorista;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ResponseStatusException;

import java.math.BigDecimal;

@Component
public class ValidarSaqueMotorista {
    private static final String SALDO_INSUFICIENTE = "Saldo nao é suficiente para esta operação";
    public void validar(Motorista motorista, BigDecimal valorSaque){
        BigDecimal saldoDoMotorista = motorista.getSaldoEmConta();

        if (valorSaque.compareTo(saldoDoMotorista) > 0){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, SALDO_INSUFICIENTE);
        }
    }
}
