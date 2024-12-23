package br.com.cwi.api.service;

import br.com.cwi.api.controller.request.SolicitarCorridaRequest;
import br.com.cwi.api.controller.response.SolicitarCorridaResponse;
import br.com.cwi.api.domain.Corrida;
import br.com.cwi.api.domain.Motorista;
import br.com.cwi.api.domain.Passageiro;
import br.com.cwi.api.domain.Status;
import br.com.cwi.api.mapper.SolicitarCorridaMapper;
import br.com.cwi.api.repository.CorridaRepository;
import br.com.cwi.api.repository.MotoristaRepository;
import br.com.cwi.api.repository.PassageiroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

import static org.springframework.http.HttpStatus.BAD_REQUEST;
import static org.springframework.http.HttpStatus.NOT_FOUND;

@Service
public class SolicitarCorridaService {

    private static final double TEMPO_ESPERA_MINIMO = 5;
    private static final double TEMPO_ESPERA_MAXIMO = 10;
    private static final String MINUTOS_TEXTO = "minutos";

    @Autowired
    private BuscarPassageiroService buscarPassageiroService;

    @Autowired
    private CorridaRepository corridaRepository;

    @Autowired
    private PassageiroRepository passageiroRepository;

    @Autowired
    private MotoristaRepository motoristaRepository;

    @Transactional
    public SolicitarCorridaResponse solicitarCorrida(Long id, SolicitarCorridaRequest request) {
        Passageiro passageiro = buscarPassageiroService.porId(id);

        boolean possuiCorridaEmAndamento = passageiro.getCorridas().stream()
                .anyMatch(corrida -> corrida.getStatus() == Status.SOLICITADA || corrida.getStatus() == Status.INICIADA);

        if(possuiCorridaEmAndamento) {
            throw  new ResponseStatusException(BAD_REQUEST, "Este passageiro já possui uma corrida em andamento.");
        }

        Corrida corrida = SolicitarCorridaMapper.toEntity(request);
        corrida.setStatus(Status.SOLICITADA);
        corrida.setPassageiro(passageiro);
        corrida.setMotorista(encontrarMotoristaParaCorrida());

        corridaRepository.save(corrida);

        SolicitarCorridaResponse response = SolicitarCorridaMapper.toResponse(corrida);

        response.setTempoEstimadoChegada(calculaTempoEstimadoDeChegada());

        return response;
    }

    private Motorista encontrarMotoristaParaCorrida() {
        List<Motorista> motoristasDisponiveisEmOrdemDeAvaliacao = motoristaRepository.findMotoristasDisponiveis();
        if(motoristasDisponiveisEmOrdemDeAvaliacao.isEmpty()) {
            throw new ResponseStatusException(NOT_FOUND, "Nenhum motorista disponível.");
        }

        Motorista primeiro = motoristasDisponiveisEmOrdemDeAvaliacao.get(0);
        List<Motorista> motoristasComMaiorNota = motoristasDisponiveisEmOrdemDeAvaliacao.stream()
                            .filter(motorista -> motorista.getMediaDasAvaliacoes() == primeiro.getMediaDasAvaliacoes())
                            .collect(Collectors.toList());
        int indiceAleatorio = new Random().nextInt(motoristasComMaiorNota.size());
        return motoristasComMaiorNota.get(indiceAleatorio);
    }

    private String calculaTempoEstimadoDeChegada() {
        int minutos = (int) (Math.floor(Math.random() * (TEMPO_ESPERA_MAXIMO - TEMPO_ESPERA_MINIMO + 1)) + TEMPO_ESPERA_MINIMO);

        return String.format("%s %s", minutos, MINUTOS_TEXTO);
    }
}
