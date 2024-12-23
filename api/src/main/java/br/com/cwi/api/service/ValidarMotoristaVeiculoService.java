package br.com.cwi.api.service;

import br.com.cwi.api.domain.Categoria;
import br.com.cwi.api.domain.Motorista;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.Objects;

import static org.springframework.http.HttpStatus.BAD_REQUEST;

@Service
public class ValidarMotoristaVeiculoService {
    @Autowired
    private BuscarMotoristaService buscarMotoristaService;
    private static final String TIPO_CARTEIRA_INVALIDO = "Este motorista nao possui habilitaçao compativel com o carro";
    private static final String MOTORISTA_JA_TEM_VEICULO = "Este motorista ja tem um veiculo";

    public Motorista validar(Categoria categoria, Long idMotorista){
        Motorista motorista = buscarMotoristaService.porId(idMotorista);

        if (motorista.getHabilitacaoCategoria() != categoria){
            throw  new ResponseStatusException(BAD_REQUEST, TIPO_CARTEIRA_INVALIDO);
        }

        if (Objects.nonNull(motorista.getVeiculo())){
            throw  new ResponseStatusException(BAD_REQUEST, MOTORISTA_JA_TEM_VEICULO);
        }

        return motorista;
    }
}
