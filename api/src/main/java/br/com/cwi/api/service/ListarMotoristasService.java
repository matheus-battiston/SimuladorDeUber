package br.com.cwi.api.service;

import br.com.cwi.api.controller.response.DetalharMotoristaResponse;
import br.com.cwi.api.controller.response.ListarMotoristaResponse;
import br.com.cwi.api.mapper.ListarMotoristasMapper;
import br.com.cwi.api.repository.MotoristaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import static br.com.cwi.api.mapper.DetalharMotoristaMapper.toResponse;

@Service
public class ListarMotoristasService {

    @Autowired
    private MotoristaRepository motoristaRepository;

    @Autowired
    private BuscarMotoristaService buscarMotoristaService;


    public Page<ListarMotoristaResponse> listar(Pageable pageable) {
        return motoristaRepository.findAll(pageable).map(ListarMotoristasMapper::toResponse);
    }

    public DetalharMotoristaResponse obterMotorista(Long id) {
        return toResponse(buscarMotoristaService.porId(id));
    }
}
