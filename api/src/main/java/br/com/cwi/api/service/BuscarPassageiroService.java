package br.com.cwi.api.service;

import br.com.cwi.api.domain.Passageiro;
import br.com.cwi.api.repository.PassageiroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import static org.springframework.http.HttpStatus.NOT_FOUND;

@Service
public class BuscarPassageiroService {

    private static final String PASSAGEIRO_NAO_ENCONTRADO = "Passageiro não encontrado";

    @Autowired
    private PassageiroRepository passageiroRepository;

    public Passageiro porId(Long id) {

        return passageiroRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(NOT_FOUND, PASSAGEIRO_NAO_ENCONTRADO));
    }
}
