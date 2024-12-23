package br.com.cwi.api.service;

import br.com.cwi.api.repository.VeiculoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import static org.springframework.http.HttpStatus.BAD_REQUEST;

@Service
public class ValidaCarroUnicoService {
    @Autowired
    private VeiculoRepository veiculoRepository;
    private static final String VEICULO_JA_CADASTRADO = "Este veiculo ja esta cadastrado";

    public void validar(String placa){
        if (veiculoRepository.existsByPlaca(placa)){
            throw new ResponseStatusException(BAD_REQUEST,VEICULO_JA_CADASTRADO);
        }
    }
}
