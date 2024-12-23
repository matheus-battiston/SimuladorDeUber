package br.com.cwi.api.controller;

import br.com.cwi.api.controller.response.DetalharCorridaResponse;
import br.com.cwi.api.service.DetalharCorridaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import static org.springframework.http.HttpStatus.OK;

@RestController
@RequestMapping("/corridas")
public class CorridaController {

    @Autowired
    private DetalharCorridaService detalharCorridaService;

    @GetMapping("/{id}")
    @ResponseStatus(OK)
    public DetalharCorridaResponse obterCorrida(@PathVariable Long id) {
        return detalharCorridaService.obterCorrida(id);
    }

}
