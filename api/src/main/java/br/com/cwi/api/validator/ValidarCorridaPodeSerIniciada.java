package br.com.cwi.api.validator;

import br.com.cwi.api.domain.Corrida;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ResponseStatusException;

import java.util.Objects;

import static br.com.cwi.api.domain.Status.SOLICITADA;
import static org.springframework.http.HttpStatus.BAD_REQUEST;

@Component
public class ValidarCorridaPodeSerIniciada {
    private static final String CORRIDA_NAO_PODE_SER_INICIADA = "O status desta corrida nao é SOLICITADA";
    private static final String CORRIDA_NAO_PERTENCE_A_ESTE_MOTORISTA = "Esta corrida nao pertence a este motorista";
    public void validar(Corrida corrida, Long idMotorista) {


        if (corrida.getStatus() != SOLICITADA){
            throw new ResponseStatusException(BAD_REQUEST, CORRIDA_NAO_PODE_SER_INICIADA);
        }

        if (!Objects.equals(corrida.getMotorista().getId(), idMotorista)){
            throw new ResponseStatusException(BAD_REQUEST, CORRIDA_NAO_PERTENCE_A_ESTE_MOTORISTA);
        }
    }
}
