package br.com.cwi.api.validator;

import br.com.cwi.api.domain.Corrida;
import br.com.cwi.api.domain.Status;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ResponseStatusException;

import java.util.Objects;

import static org.springframework.http.HttpStatus.BAD_REQUEST;

@Component
public class ValidarCorridaPodeSerFinalizada {
    private static final String CORRIDA_NAO_ESTA_EM_ANDAMENTO = "A corrida nao esta em andamento";
    private static final String MOTORISTA_ERRADO = "Apenas o motorista da corrida pode finalizar ela";
    public void validar(Corrida corrida, Long idMotorista){

        if(!Objects.equals(corrida.getMotorista().getId(), idMotorista)){
            throw new ResponseStatusException(BAD_REQUEST, MOTORISTA_ERRADO);
        } else if (corrida.getStatus() != Status.INICIADA){
            throw new ResponseStatusException(BAD_REQUEST, CORRIDA_NAO_ESTA_EM_ANDAMENTO);
        }
    }
}
