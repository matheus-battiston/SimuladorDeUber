package br.com.cwi.api.service;

import br.com.cwi.api.domain.Corrida;
import br.com.cwi.api.repository.CorridaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import static org.springframework.http.HttpStatus.UNPROCESSABLE_ENTITY;

@Service
public class BuscarCorridaService {
    private static final String CORRIDA_NAO_EXISTE = "Corrida não encontrada";

    @Autowired
    CorridaRepository corridaRepository;

    public Corrida porId(Long idCorrida){
        return corridaRepository.findById(idCorrida)
                .orElseThrow(() -> new ResponseStatusException(UNPROCESSABLE_ENTITY, CORRIDA_NAO_EXISTE));

    }
}
