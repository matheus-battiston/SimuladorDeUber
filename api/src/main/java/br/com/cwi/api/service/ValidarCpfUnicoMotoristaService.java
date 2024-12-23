package br.com.cwi.api.service;

import br.com.cwi.api.repository.MotoristaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import static org.springframework.http.HttpStatus.BAD_REQUEST;

@Service
public class ValidarCpfUnicoMotoristaService {
    private static final String CPF_JA_EXISTE = "Este cpf ja foi cadastrado por um motorista";

    @Autowired
    private MotoristaRepository motoristaRepository;
    public void validar(String cpf){
        if (motoristaRepository.existsByCpf(cpf)){
            throw new ResponseStatusException(BAD_REQUEST, CPF_JA_EXISTE);
        }
    }
}
