package br.com.banco.services;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.banco.models.Transferencia;
import br.com.banco.repositories.TransferenciaRepository;

@Service
public class TransferenciaService {
    
    @Autowired
    private TransferenciaRepository transferenciaRepository;

    @Autowired
    private ContaService contaService;

    public List<Transferencia> findByContaId(Long contaId) {
        this.contaService.findById(contaId);
        return this.transferenciaRepository.findByContaId(contaId);
    }

    public List<Transferencia> findAll() {
        return this.transferenciaRepository.findAll();
    }

    public List<Transferencia> findByNomeOperador(String nomeOperador) {
        return this.transferenciaRepository.findByNomeOperador(nomeOperador);
    }

    public List<Transferencia> findBetweenDates(String first, String last) {
        DateTimeFormatter fmt =  DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime firsTime = LocalDateTime.parse(first, fmt);
        LocalDateTime lastTime = LocalDateTime.parse(last, fmt).plusDays(1);

        return this.transferenciaRepository.findBetweenDates(firsTime, lastTime);
    }
}
