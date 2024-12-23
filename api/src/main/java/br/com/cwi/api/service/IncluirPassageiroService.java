package br.com.cwi.api.service;

import br.com.cwi.api.controller.request.IncluirPassageiroRequest;
import br.com.cwi.api.controller.response.IdResponse;
import br.com.cwi.api.domain.Passageiro;
import br.com.cwi.api.mapper.IncluirPassageiroMapper;
import br.com.cwi.api.repository.PassageiroRepository;
import br.com.cwi.api.validator.ValidarPassageiroIdade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;

@Service
public class IncluirPassageiroService {

    private static  final int VALOR_INICIAL_SOMA_NOTAS = 0;
    private static  final int VALOR_INICIAL_NRO_CORRIDAS = 0;
    private static  final BigDecimal VALOR_INICIAL_SALDO = new BigDecimal("0");
    private static final float VALOR_INICIAL_MEDIA = 5;
    private static final int VALOR_INICIAL_QUANT_AVALIACOES = 0;

    @Autowired
    private PassageiroRepository passageiroRepository;

    @Autowired
    private ValidarPassageiroIdade validarPassageiroIdade;

    @Autowired
    private ValidarCpfUnicoPassageiroService validarCpfUnicoPassageiroService;

    @Transactional
    public IdResponse incluir(IncluirPassageiroRequest request) {

        validarPassageiroIdade.validar(request.getDataNascimento());
        validarCpfUnicoPassageiroService.validar(request.getCpf());

        Passageiro passageiro = IncluirPassageiroMapper.toEntity(request);

        passageiro.setSomaDasNotas(VALOR_INICIAL_SOMA_NOTAS);
        passageiro.setNumeroDeCorridas(VALOR_INICIAL_NRO_CORRIDAS);
        passageiro.setSaldoEmConta(VALOR_INICIAL_SALDO);
        passageiro.setMediaDasAvaliacoes(VALOR_INICIAL_MEDIA);
        passageiro.setQuantidadeDeAvaliacoes(VALOR_INICIAL_QUANT_AVALIACOES);

        passageiroRepository.save(passageiro);

        return IncluirPassageiroMapper.toResponse(passageiro);
    }
}
