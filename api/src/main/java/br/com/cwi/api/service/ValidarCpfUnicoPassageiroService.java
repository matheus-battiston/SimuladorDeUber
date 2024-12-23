package br.com.cwi.api.service;

import br.com.cwi.api.repository.PassageiroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import static org.springframework.http.HttpStatus.BAD_REQUEST;

@Service
public class ValidarCpfUnicoPassageiroService {

    private static final String CPF_PASSAGEIRO_JA_EXISTE = "Já existe um passageiro com esse CPF";

    @Autowired
    private PassageiroRepository passageiroRepository;

    public void validar(String cpf) {

        if (passageiroRepository.existsByCpf(cpf)) {
            throw new ResponseStatusException(BAD_REQUEST, CPF_PASSAGEIRO_JA_EXISTE);
        }
    }
}
