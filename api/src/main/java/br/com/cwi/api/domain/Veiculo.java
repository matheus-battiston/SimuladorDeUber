package br.com.cwi.api.domain;


import lombok.*;

import javax.persistence.*;

import static javax.persistence.GenerationType.IDENTITY;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(of = "id") @ToString(of = "id")
@Entity
public class Veiculo {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;

    private String placa;
    private String modelo;
    private String cor;
    private String fotoUrl;

    @Enumerated(EnumType.STRING)
    private Categoria categoria;

    @OneToOne
    @JoinColumn(name = "proprietario_id")
    private Motorista proprietario;
}
