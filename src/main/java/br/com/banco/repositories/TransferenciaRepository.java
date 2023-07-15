package br.com.banco.repositories;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.banco.models.Transferencia;

@Repository
public interface TransferenciaRepository extends JpaRepository<Transferencia, Long> {
    
    @Query(value = "SELECT * FROM TRANSFERENCIA t WHERE t.conta_id = :contaId", nativeQuery = true)
    List<Transferencia> findByContaId(@Param(value = "contaId") Long contaId);

    @Query(value = "SELECT * FROM TRANSFERENCIA t WHERE t.nome_operador_transacao = :nomeOperador", nativeQuery = true)
    List<Transferencia> findByNomeOperador(@Param(value = "nomeOperador") String nomeOperador);
    
    @Query(value = "SELECT * FROM TRANSFERENCIA t WHERE t.data_transferencia BETWEEN :first AND :last ", nativeQuery = true)
    List<Transferencia> findBetweenDates(@Param(value = "first") LocalDateTime first, @Param(value = "last") LocalDateTime last);

    @Query(value = "SELECT * FROM TRANSFERENCIA t WHERE t.nome_operador_transacao = :nome AND t.data_transferencia BETWEEN :first AND :last ", nativeQuery = true)
    List<Transferencia> findBetweenDatesAndOperador(@Param(value = "nome") String nome, @Param(value = "first") LocalDateTime first, @Param(value = "last") LocalDateTime last);

}
