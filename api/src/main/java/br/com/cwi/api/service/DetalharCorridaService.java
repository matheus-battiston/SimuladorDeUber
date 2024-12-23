package br.com.cwi.api.service;

import br.com.cwi.api.controller.response.DetalharCorridaResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import static br.com.cwi.api.mapper.DetalharCorridaMapper.toResponse;

@Service
public class DetalharCorridaService {

    @Autowired
    private BuscarCorridaService buscarCorridaService;

    public DetalharCorridaResponse obterCorrida(Long id) {
        return toResponse(buscarCorridaService.porId(id));
    }
}
