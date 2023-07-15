package br.com.banco.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.banco.models.Transferencia;
import br.com.banco.repositories.TransferenciaRepository;

@Service
public class TransferenciaService {
    
    @Autowired
    private TransferenciaRepository transferenciaRepository;

    public List<Transferencia> findByContaId(Long contaId) {
        return this.transferenciaRepository.findByContaId(contaId);
    }

}