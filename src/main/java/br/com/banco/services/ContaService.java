package br.com.banco.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.banco.models.Conta;
import br.com.banco.repositories.ContaRepository;
import br.com.banco.services.exceptions.ObjectNotFound;

@Service
public class ContaService {
    
    @Autowired
    private ContaRepository contaRepository;

    public Conta findById(Long idConta) {
        return this.contaRepository.findById(idConta)
                .orElseThrow(() -> new ObjectNotFound("Conta inexistente"));
    }

}
