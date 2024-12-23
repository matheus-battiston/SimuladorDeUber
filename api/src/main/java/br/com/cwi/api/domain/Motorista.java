package br.com.cwi.api.domain;

import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static javax.persistence.GenerationType.IDENTITY;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(of = "id") @ToString(of = "id")
@Entity
public class Motorista {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;

    private String nome;
    private LocalDate dataNascimento;
    private String cpf;
    private BigDecimal saldoEmConta;
    private String habilitacaoNumero;

    @Enumerated(EnumType.STRING)
    private Categoria habilitacaoCategoria;

    private LocalDate habilitacaoDataVencimento;
    private Integer quantidadeDeAvaliacoes;
    private Integer somaDasNotas;
    private double mediaDasAvaliacoes;
    private Integer numeroDeCorridas;

    @OneToOne(mappedBy = "proprietario")
    private Veiculo veiculo;

    @OneToMany(mappedBy = "motorista")
    private List<Corrida> corridas = new ArrayList<>();

    public void receberCorrida(BigDecimal valorTotalDaCorrida) {
        this.saldoEmConta = this.saldoEmConta.add(valorTotalDaCorrida);
    }
}

