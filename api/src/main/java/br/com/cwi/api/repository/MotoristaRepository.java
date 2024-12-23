package br.com.cwi.api.repository;

import br.com.cwi.api.domain.Motorista;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;


public interface MotoristaRepository extends JpaRepository<Motorista, Long> {
   
    boolean existsByCpf(String cpf);


    @Query("select m from Motorista m join m.veiculo v where not exists (select c from m.corridas c where c.status <> 'FINALIZADA') " +
            "and m.habilitacaoDataVencimento >= CURRENT_DATE " +
            "order by m.mediaDasAvaliacoes desc")
    List<Motorista> findMotoristasDisponiveis ();

    boolean existsByHabilitacaoNumero(String habilitacaoNumero);
}

