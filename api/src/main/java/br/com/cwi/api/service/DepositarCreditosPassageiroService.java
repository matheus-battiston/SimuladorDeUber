package br.com.cwi.api.service;

import br.com.cwi.api.controller.request.DepositarCreditosPassageiroRequest;
import br.com.cwi.api.controller.response.DepositarCreditosPassageiroResponse;
import br.com.cwi.api.domain.Passageiro;
import br.com.cwi.api.repository.PassageiroRepository;
import br.com.cwi.api.validator.ValidarDepositoPassageiro;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;

import static br.com.cwi.api.mapper.DepositarCreditosPassageiroMapper.toResponse;

@Service
public class DepositarCreditosPassageiroService {

    @Autowired
    private PassageiroRepository passageiroRepository;

    @Autowired
    private BuscarPassageiroService buscarPassageiroService;

    @Autowired
    private ValidarDepositoPassageiro validarDepositoPassageiro;

    @Transactional
    public DepositarCreditosPassageiroResponse depositar(Long id, DepositarCreditosPassageiroRequest request) {

        Passageiro passageiro = buscarPassageiroService.porId(id);

        validarDepositoPassageiro.validarValorMaiorQueZero(request.getValorDeposito());

        BigDecimal novoSaldo = passageiro.getSaldoEmConta().add(request.getValorDeposito());
        passageiro.setSaldoEmConta(novoSaldo);

        passageiroRepository.save(passageiro);

        return toResponse(passageiro);
    }
}

