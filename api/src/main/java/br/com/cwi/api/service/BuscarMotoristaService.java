package br.com.cwi.api.service;

import br.com.cwi.api.domain.Motorista;
import br.com.cwi.api.repository.MotoristaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import static org.springframework.http.HttpStatus.UNPROCESSABLE_ENTITY;

@Service
public class BuscarMotoristaService {
    private static final String MOTORISTA_NAO_ENCONTRADO = "Esse motorista nao foi encontrado";
    @Autowired
    MotoristaRepository motoristaRepository;
    public Motorista porId(Long id){

        return motoristaRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(UNPROCESSABLE_ENTITY, MOTORISTA_NAO_ENCONTRADO));
    }
}
