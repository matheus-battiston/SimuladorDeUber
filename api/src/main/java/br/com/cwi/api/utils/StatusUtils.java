package br.com.cwi.api.utils;

import br.com.cwi.api.domain.Motorista;
import br.com.cwi.api.domain.Passageiro;
import br.com.cwi.api.domain.Status;

public class StatusUtils {
    public static String calculaStatusMotorista(Motorista entity) {
        String status = "Disponível";

        if(entity.getCorridas().stream().anyMatch(corrida -> corrida.getStatus() == Status.INICIADA)) {
            status = "Em corrida";
        }
        else if(entity.getCorridas().stream().anyMatch(corrida -> corrida.getStatus() == Status.SOLICITADA)) {
            status = "Pendente de aceite";
        }

        return status;
    }

    public static String calculaStatusPassageiro(Passageiro entity) {
        String status = "Disponível";

        if(entity.getCorridas().stream().anyMatch(corrida -> corrida.getStatus() == Status.INICIADA)) {
            status = "Em corrida";
        }
        else if(entity.getCorridas().stream().anyMatch(corrida -> corrida.getStatus() == Status.SOLICITADA)) {
            status = "Aguardando aceite do motorista";
        }
        return status;
    }
}
