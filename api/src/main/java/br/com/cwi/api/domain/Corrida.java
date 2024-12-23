package br.com.cwi.api.domain;

import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.Duration;
import java.time.LocalDateTime;

import static java.lang.Math.*;
import static javax.persistence.GenerationType.IDENTITY;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(of = "id") @ToString(of = "id")
@Entity
public class Corrida {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;

    private BigDecimal inicioX;
    private BigDecimal inicioY;
    private BigDecimal finalX;
    private BigDecimal finalY;
    private LocalDateTime horarioInicio;
    private LocalDateTime horarioChegada;

    @Enumerated(EnumType.STRING)
    private Status status;

    private BigDecimal valorEstimado;
    private BigDecimal valorTotal;

    private Integer notaMotorista;
    private Integer notaPassageiro;

    @ManyToOne
    @JoinColumn(name = "motorista_id")
    private Motorista motorista;

    @ManyToOne
    @JoinColumn(name = "passageiro_id")
    private Passageiro passageiro;

    public BigDecimal calcularDistancia() {
        double earthRadius = 6371;

        double lat1 = this.finalX.doubleValue();
        double long1 = this.finalY.doubleValue();
        double lat2 = this.inicioX.doubleValue();
        double long2 = this.inicioY.doubleValue();

        double distance = acos(sin(lat2 * PI / 180.0) * sin(lat1 * PI / 180.0) +
                cos(lat2 * PI / 180.0) * cos(lat1 * PI / 180.0) *
                        cos((long1 - long2) * PI / 180.0)) * earthRadius;

        return BigDecimal.valueOf(distance);
    }


    public void definirValorTotalCorrida(){
        BigDecimal valorDaCorridaPorSegundo = BigDecimal.valueOf(0.2);
        long duracaoDaCorrida = Duration.between(this.horarioInicio, this.horarioChegada).getSeconds();

        this.valorTotal = valorDaCorridaPorSegundo.multiply(BigDecimal.valueOf(duracaoDaCorrida));

    }
}

