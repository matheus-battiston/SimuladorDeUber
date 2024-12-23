package br.com.cwi.api.service;

import br.com.cwi.api.controller.request.IncluirVeiculoRequest;
import br.com.cwi.api.controller.response.IdResponse;
import br.com.cwi.api.domain.Motorista;
import br.com.cwi.api.domain.Veiculo;
import br.com.cwi.api.repository.VeiculoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import static br.com.cwi.api.mapper.IncluirVeiculoMapper.toEntity;
import static br.com.cwi.api.mapper.IncluirVeiculoMapper.toResponse;

@Service
public class IncluirVeiculoService {

    @Autowired
    private VeiculoRepository veiculoRepository;
    @Autowired
    private ValidaCarroUnicoService validaCarroUnicoService;
    @Autowired
    private ValidarMotoristaVeiculoService validarMotoristaVeiculoService;

    @Transactional
    public IdResponse incluir(IncluirVeiculoRequest request) {

        validaCarroUnicoService.validar(request.getPlaca());
        Motorista motorista = validarMotoristaVeiculoService
                .validar(request.getCategoria(), request.getProprietarioId());

        Veiculo veiculo = toEntity(request);
        veiculo.setProprietario(motorista);

        veiculoRepository.save(veiculo);
        return toResponse(veiculo);
    }
}
