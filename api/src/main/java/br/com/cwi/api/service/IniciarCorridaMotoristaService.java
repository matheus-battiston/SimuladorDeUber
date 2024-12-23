package br.com.cwi.api.service;

import br.com.cwi.api.controller.response.IniciarCorridaMotoristaResponse;
import br.com.cwi.api.domain.Corrida;
import br.com.cwi.api.validator.ValidarCorridaPodeSerIniciada;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.math.RoundingMode;

import static br.com.cwi.api.domain.Status.INICIADA;
import static br.com.cwi.api.mapper.IniciarCorridaMotoristaMapper.toResponse;
import static java.time.LocalDateTime.now;

@Service
public class IniciarCorridaMotoristaService {
    @Autowired
    private BuscarCorridaService buscarCorridaService;
    @Autowired
    private ValidarCorridaPodeSerIniciada validarCorridaPodeSerIniciada;

    @Transactional
    public IniciarCorridaMotoristaResponse iniciar(Long idMotorista, Long idCorrida) {

        Corrida corrida = buscarCorridaService.porId(idCorrida);
        validarCorridaPodeSerIniciada.validar(corrida, idMotorista);

        BigDecimal distancia = corrida.calcularDistancia();
        int tempoEmSegundos = tempoEstimadoEmSegundos(distancia);
        BigDecimal valorEstimadoCorrida = calcularValorCorrida(tempoEmSegundos);

        corrida.setValorEstimado(valorEstimadoCorrida);
        corrida.setStatus(INICIADA);
        corrida.setHorarioInicio(now());

        return toResponse(tempoEmSegundos, valorEstimadoCorrida);
    }

    private int tempoEstimadoEmSegundos(BigDecimal distancia){
        BigDecimal segundos = BigDecimal.valueOf(60);
        BigDecimal minutos = BigDecimal.valueOf(60);


        BigDecimal velocidadeMediaKmPorHora = BigDecimal.valueOf(30);
        BigDecimal tempo = distancia.divide(velocidadeMediaKmPorHora, RoundingMode.CEILING)
                .multiply(segundos)
                .multiply(minutos);

        return tempo.intValue();
    }

    private BigDecimal calcularValorCorrida(int tempoEmSegundos){
        BigDecimal valorPorSegundo = BigDecimal.valueOf(0.2);
        return valorPorSegundo.multiply(BigDecimal.valueOf(tempoEmSegundos));
    }
}
