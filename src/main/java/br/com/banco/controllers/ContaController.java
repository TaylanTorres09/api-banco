package br.com.banco.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.banco.models.Conta;
import br.com.banco.services.ContaService;

@RestController
@RequestMapping("/conta")
public class ContaController {
    
    @Autowired
    private ContaService contaService;

    @GetMapping("/{contaId}")
    public Conta findById(@PathVariable Long contaId) {
        return this.contaService.findById(contaId);
    }

}
