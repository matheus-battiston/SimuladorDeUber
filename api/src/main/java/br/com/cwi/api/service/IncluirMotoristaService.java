package br.com.cwi.api.service;

import br.com.cwi.api.controller.request.IncluirMotoristaRequest;
import br.com.cwi.api.controller.response.IdResponse;
import br.com.cwi.api.domain.Motorista;
import br.com.cwi.api.repository.MotoristaRepository;
import br.com.cwi.api.validator.ValidarMotoristaIdade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;

import static br.com.cwi.api.mapper.IncluirMotoristaMapper.toEntity;
import static br.com.cwi.api.mapper.IncluirMotoristaMapper.toResponse;

@Service
public class IncluirMotoristaService {
    private static final int VALOR_INICIAL_SOMA_NOTAS = 0;
    private static final int VALOR_INICIAL_NRO_CORRIDAS = 0;
    private static final BigDecimal VALOR_INICIAL_SALDO = BigDecimal.valueOf(0);
    private static final float VALOR_INICIAL_MEDIA = 5;
    private static final int VALOR_INICIAL_QUANT_AVALIACOES = 0;

    @Autowired
    private MotoristaRepository motoristaRepository;
    @Autowired
    private ValidarCpfUnicoMotoristaService validarCpfUnicoMotoristaService;
    @Autowired
    private ValidarMotoristaIdade validarMotoristaIdade;
    @Autowired
    private ValidarCnhUnicaSerivce validarCnhUnicaSerivce;

    @Transactional
    public IdResponse incluir(IncluirMotoristaRequest request){

        validarMotoristaIdade.validar(request.getDataNascimento());
        validarCpfUnicoMotoristaService.validar(request.getCpf());
        validarCnhUnicaSerivce.validar(request.getHabilitacaoNumero());

        Motorista motorista = toEntity(request);

        motorista.setSomaDasNotas(VALOR_INICIAL_SOMA_NOTAS);
        motorista.setNumeroDeCorridas(VALOR_INICIAL_NRO_CORRIDAS);
        motorista.setSaldoEmConta(VALOR_INICIAL_SALDO);
        motorista.setMediaDasAvaliacoes(VALOR_INICIAL_MEDIA);
        motorista.setQuantidadeDeAvaliacoes(VALOR_INICIAL_QUANT_AVALIACOES);

        motoristaRepository.save(motorista);

        return toResponse(motorista);
    }
}
