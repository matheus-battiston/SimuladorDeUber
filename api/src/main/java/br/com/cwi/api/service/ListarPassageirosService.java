package br.com.cwi.api.service;

import br.com.cwi.api.controller.response.DetalharPassageiroResponse;
import br.com.cwi.api.controller.response.ListarPassageiroResponse;
import br.com.cwi.api.mapper.ListarPassageirosMapper;
import br.com.cwi.api.repository.PassageiroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import static br.com.cwi.api.mapper.DetalharPassageiroMapper.toResponse;

@Service
public class ListarPassageirosService {

    @Autowired
    private PassageiroRepository passageiroRepository;

    @Autowired
    private BuscarPassageiroService buscarPassageiroService;

    public Page<ListarPassageiroResponse> listar(Pageable pageable) {
        return passageiroRepository.findAll(pageable).map(ListarPassageirosMapper::toResponse);
    }

    public Page<ListarPassageiroResponse> listarHabilitados(Pageable pageable) {
        return passageiroRepository.findPassageirosHabilitados(pageable)
                .map(ListarPassageirosMapper::toResponse);
    }

    public DetalharPassageiroResponse obterPassageiro(Long id) {
        return toResponse(buscarPassageiroService.porId(id));
    }
}
