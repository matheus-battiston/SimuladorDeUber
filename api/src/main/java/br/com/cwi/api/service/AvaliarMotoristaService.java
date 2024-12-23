package br.com.cwi.api.service;

import br.com.cwi.api.controller.request.AvaliarRequest;
import br.com.cwi.api.domain.Corrida;
import br.com.cwi.api.domain.Motorista;
import br.com.cwi.api.domain.Status;
import br.com.cwi.api.repository.CorridaRepository;
import br.com.cwi.api.repository.MotoristaRepository;
import br.com.cwi.api.utils.AvaliacoesUtils;
import br.com.cwi.api.validator.ValidarNotaAvaliacao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import static org.springframework.http.HttpStatus.BAD_REQUEST;

@Service
public class AvaliarMotoristaService {

    private static final Integer UMA_AVALIACAO_NOVA = 1;

    @Autowired
    private MotoristaRepository motoristaRepository;

    @Autowired
    private CorridaRepository corridaRepository;

    @Autowired
    private BuscarCorridaService buscarCorridaService;

    @Autowired
    private ValidarNotaAvaliacao validarNotaAvaliacao;

    @Transactional
    public void avaliar(AvaliarRequest request) {

        validarNotaAvaliacao.validarNota(request.getNota());

        Corrida corrida = buscarCorridaService.porId(request.getIdDaCorrida());

        if(corrida.getStatus() != Status.FINALIZADA) {
            throw new ResponseStatusException(BAD_REQUEST, "Para avaliar a corrida precisa ter sido finalizada");
        }

        if(corrida.getNotaMotorista() != null) {
            throw new ResponseStatusException(BAD_REQUEST, "O motorista já foi avaliado nesta corrida");
        }

        corrida.setNotaMotorista(request.getNota());
        corridaRepository.save(corrida);

        Motorista motorista = corrida.getMotorista();
        motorista.setSomaDasNotas(Integer.sum(motorista.getSomaDasNotas(), request.getNota()));
        motorista.setQuantidadeDeAvaliacoes(Integer.sum(motorista.getQuantidadeDeAvaliacoes(), UMA_AVALIACAO_NOVA));

        double novaMedia = AvaliacoesUtils.calcularMedia(motorista.getSomaDasNotas(), motorista.getQuantidadeDeAvaliacoes());
        motorista.setMediaDasAvaliacoes(novaMedia);

        motoristaRepository.save(motorista);
    }

}
