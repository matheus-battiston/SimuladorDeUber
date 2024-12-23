package br.com.cwi.api.controller;

import br.com.cwi.api.controller.request.AvaliarRequest;
import br.com.cwi.api.controller.request.DepositarCreditosPassageiroRequest;
import br.com.cwi.api.controller.request.IncluirPassageiroRequest;
import br.com.cwi.api.controller.request.SolicitarCorridaRequest;
import br.com.cwi.api.controller.response.*;
import br.com.cwi.api.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.OK;

@RestController
@RequestMapping("/passageiros")
public class PassageiroController {

    @Autowired
    private ListarPassageirosService listarPassageirosService;

    @Autowired
    private IncluirPassageiroService incluirPassageiroService;

    @Autowired
    private SolicitarCorridaService solicitarCorridaService;

    @Autowired
    private DepositarCreditosPassageiroService depositarCreditosPassageiroService;

    @Autowired
    private AvaliarMotoristaService avaliarMotoristaService;

    @GetMapping()
    @ResponseStatus(OK)
    public Page<ListarPassageiroResponse> listarMotoristas(Pageable pageable) {
        return listarPassageirosService.listar(pageable);
    }

    @GetMapping("/{id}")
    @ResponseStatus(OK)
    public DetalharPassageiroResponse obterPassageiro(@PathVariable Long id) {
        return listarPassageirosService.obterPassageiro(id);
    }

    @GetMapping("/habilitados")
    @ResponseStatus(OK)
    public Page<ListarPassageiroResponse> listarPassageirosHabilitados (Pageable pageable) {
        return listarPassageirosService.listarHabilitados(pageable);
    }



    @PostMapping("/{id}/solicitar-corrida")
    @ResponseStatus(OK)
    public SolicitarCorridaResponse solicitarCorrida(@PathVariable Long id,
                                                     @Valid @RequestBody SolicitarCorridaRequest request) {
        return solicitarCorridaService.solicitarCorrida(id, request);
    }

    @PostMapping
    @ResponseStatus(CREATED)
    public IdResponse incluir(@Valid @RequestBody IncluirPassageiroRequest request){
        return incluirPassageiroService.incluir(request);
    }

    @PutMapping("/{id}/depositar-creditos")
    @ResponseStatus(OK)
    public DepositarCreditosPassageiroResponse depositarCreditos(@PathVariable Long id,
                                                                 @Valid @RequestBody DepositarCreditosPassageiroRequest request){
        return depositarCreditosPassageiroService.depositar(id, request);
    }

    @PutMapping("/avaliar-motorista")
    @ResponseStatus(OK)
    public void avaliarMotorista(@Valid @RequestBody AvaliarRequest request) {
        avaliarMotoristaService.avaliar(request);
    }
}
