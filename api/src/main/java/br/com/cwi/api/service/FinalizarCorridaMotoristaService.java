package br.com.cwi.api.service;

import br.com.cwi.api.controller.response.FinalizarCorridaResponse;
import br.com.cwi.api.domain.Corrida;
import br.com.cwi.api.domain.Motorista;
import br.com.cwi.api.domain.Passageiro;
import br.com.cwi.api.repository.CorridaRepository;
import br.com.cwi.api.validator.ValidarCorridaPodeSerFinalizada;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import static br.com.cwi.api.domain.Status.FINALIZADA;
import static br.com.cwi.api.mapper.FinalizarCorridaMapper.toResponse;
import static java.time.LocalDateTime.now;

@Service
public class FinalizarCorridaMotoristaService {

    private static final Integer UMA_NOVA_CORRIDA = 1;
    @Autowired
    private BuscarCorridaService buscarCorridaService;
    @Autowired
    private BuscarMotoristaService buscarMotoristaService;

    @Autowired
    private ValidarCorridaPodeSerFinalizada validarCorridaPodeSerFinalizada;
    @Autowired
    private CorridaRepository corridaRepository;


    @Transactional
    public FinalizarCorridaResponse finalizar(Long idMotorista, Long idCorrida) {

        Corrida corrida = buscarCorridaService.porId(idCorrida);
        Motorista motorista = buscarMotoristaService.porId(idMotorista);
        validarCorridaPodeSerFinalizada.validar(corrida, idMotorista);
        Passageiro passageiro = corrida.getPassageiro();

        corrida.setHorarioChegada(now());
        corrida.setStatus(FINALIZADA);
        passageiro.setNumeroDeCorridas(passageiro.getNumeroDeCorridas() + UMA_NOVA_CORRIDA);
        motorista.setNumeroDeCorridas(motorista.getNumeroDeCorridas() + UMA_NOVA_CORRIDA);

        corrida.definirValorTotalCorrida();

        passageiro.pagarCorrida(corrida.getValorTotal());
        motorista.receberCorrida(corrida.getValorTotal());

        corridaRepository.save(corrida);
        return toResponse(corrida);
    }
}
