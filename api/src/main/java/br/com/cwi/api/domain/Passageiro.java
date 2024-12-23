package br.com.cwi.api.domain;

import lombok.*;
import org.springframework.web.server.ResponseStatusException;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static javax.persistence.GenerationType.IDENTITY;
import static org.springframework.http.HttpStatus.UNPROCESSABLE_ENTITY;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(of = "id") @ToString(of = "id")
@Entity
public class Passageiro {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;

    private String nome;
    private LocalDate dataNascimento;
    private String cpf;
    private BigDecimal saldoEmConta;
    private Integer quantidadeDeAvaliacoes;
    private Integer somaDasNotas;
    private double mediaDasAvaliacoes;
    private Integer numeroDeCorridas;

    @OneToMany(mappedBy = "passageiro")
    private List<Corrida> corridas = new ArrayList<>();

    public void pagarCorrida(BigDecimal valorTotalDaCorrida) {
        final String saldoInsuficiente = "O passageiro nao possui saldo suficiente para o pagamento";
        if (valorTotalDaCorrida.compareTo(this.saldoEmConta) > 0){
            throw new ResponseStatusException(UNPROCESSABLE_ENTITY, saldoInsuficiente);
        }

        this.saldoEmConta = this.saldoEmConta.subtract(valorTotalDaCorrida);
    }
}