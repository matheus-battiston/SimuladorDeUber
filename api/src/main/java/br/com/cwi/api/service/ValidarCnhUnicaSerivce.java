package br.com.cwi.api.service;

import br.com.cwi.api.repository.MotoristaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import static org.springframework.http.HttpStatus.BAD_REQUEST;

@Service
public class ValidarCnhUnicaSerivce {

    @Autowired
    private MotoristaRepository motoristaRepository;
    private static final String CNH_JA_CADASTRADA = "Esta cnh ja está cadastrada para outro motorista";

    public void validar(String habilitacaoNumero) {
        if(motoristaRepository.existsByHabilitacaoNumero(habilitacaoNumero)){
            throw new ResponseStatusException(BAD_REQUEST, CNH_JA_CADASTRADA);
        }
    }
}
