package br.com.cwi.api.controller;

import br.com.cwi.api.controller.request.AvaliarRequest;
import br.com.cwi.api.controller.request.IncluirMotoristaRequest;
import br.com.cwi.api.controller.request.SacarMotoristaRequest;
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
@RequestMapping("/motoristas")
public class MotoristaController {

    @Autowired
    private IniciarCorridaMotoristaService iniciarCorridaMotoristaService;
    @Autowired
    private IncluirMotoristaService incluirMotoristaService;
    @Autowired
    private SacarMotoristaService sacarMotoristaService;
    @Autowired
    private FinalizarCorridaMotoristaService finalizarCorridaMotoristaService;
    @Autowired
    private AvaliarPassageiroService avaliarPassageiroService;

    @Autowired
    private ListarMotoristasService listarMotoristasService;

    @GetMapping()
    @ResponseStatus(OK)
    public Page<ListarMotoristaResponse> listarMotoristas(Pageable pageable) {
        return listarMotoristasService.listar(pageable);
    }

    @GetMapping("/{id}")
    @ResponseStatus(OK)
    public DetalharMotoristaResponse obterMotorista(@PathVariable Long id) {
        return listarMotoristasService.obterMotorista(id);
    }

    @PostMapping
    @ResponseStatus(CREATED)
    public IdResponse incluir(@Valid @RequestBody IncluirMotoristaRequest request){
        return incluirMotoristaService.incluir(request);
    }

    @PutMapping("/{id}/sacar")
    @ResponseStatus(OK)
    public SaqueMotoristaResponse sacar(@Valid @RequestBody SacarMotoristaRequest request,
                                        @PathVariable Long id){

        return sacarMotoristaService.sacar(id, request);
    }

    @PutMapping("{idMotorista}/iniciar-corrida/{idCorrida}")
    @ResponseStatus(OK)
    public IniciarCorridaMotoristaResponse iniciar(@PathVariable Long idMotorista, @PathVariable Long idCorrida){
        return iniciarCorridaMotoristaService.iniciar(idMotorista, idCorrida);
    }

    @PutMapping("{idMotorista}/finalizar-corrida/{idCorrida}")
    @ResponseStatus(OK)
    public FinalizarCorridaResponse finalizar(@PathVariable Long idMotorista, @PathVariable Long idCorrida){
        return finalizarCorridaMotoristaService.finalizar(idMotorista, idCorrida);
    }
    
    @PutMapping("/avaliar-passageiro")
    @ResponseStatus(OK)
    public void avaliarPassageiro(@Valid @RequestBody AvaliarRequest request) {
        avaliarPassageiroService.avaliar(request);
    }


}
