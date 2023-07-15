package br.com.banco.repositories;

import java.util.Collection;
import java.util.List;
import java.util.stream.Stream;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.banco.models.Transferencia;

@Repository
public interface TransferenciaRepository extends JpaRepository<Transferencia, Long> {
    
    @Query(value = "SELECT * FROM TRANSFERENCIA t WHERE t.conta_id = :contaId", nativeQuery = true)
    List<Transferencia> findByContaId(@Param(value = "contaId") Long contaId);

}
