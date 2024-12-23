package br.com.cwi.api.service;

import br.com.cwi.api.controller.request.SacarMotoristaRequest;
import br.com.cwi.api.controller.response.SaqueMotoristaResponse;
import br.com.cwi.api.domain.Motorista;
import br.com.cwi.api.repository.MotoristaRepository;
import br.com.cwi.api.validator.ValidarSaqueMotorista;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;

import static br.com.cwi.api.mapper.SaqueMotoristaMapper.toResponse;

@Service
public class SacarMotoristaService {
    @Autowired
    private BuscarMotoristaService buscarMotoristaService;
    @Autowired
    private ValidarSaqueMotorista validarSaqueMotorista;
    @Autowired
    private MotoristaRepository motoristaRepository;

    @Transactional
    public SaqueMotoristaResponse sacar(Long idMotorista, SacarMotoristaRequest request) {
        Motorista motorista = buscarMotoristaService.porId(idMotorista);
        validarSaqueMotorista.validar(motorista, request.getValorSaque());

        BigDecimal novoSaldo = motorista.getSaldoEmConta().subtract(request.getValorSaque());
        motorista.setSaldoEmConta(novoSaldo);

        motoristaRepository.save(motorista);

        return toResponse(motorista);


    }
}
