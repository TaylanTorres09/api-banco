package br.com.banco.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.banco.models.Transferencia;
import br.com.banco.services.TransferenciaService;

@RestController
@RequestMapping("/transferencia")
@CrossOrigin(origins = "*")
public class TransferenciaController {
    
    @Autowired
    private TransferenciaService transferenciaService;

    @GetMapping
    public List<Transferencia> findByContaId(@RequestParam Long contaId) {
        return this.transferenciaService.findByContaId(contaId);
    }

    @GetMapping("/all")
    public List<Transferencia> findAll() {
        return this.transferenciaService.findAll();
    }

    @GetMapping("/{nomeOperador}")
    public List<Transferencia> findByNomeOperador(@PathVariable String nomeOperador) {
        return this.transferenciaService.findByNomeOperador(nomeOperador);
    }

    @GetMapping("/datas")
    public List<Transferencia> findBetweenDates(@RequestParam String first, @RequestParam String last) {
        return this.transferenciaService.findBetweenDates(first, last);
    }

    @GetMapping("/datas-operador")
    public List<Transferencia> findBetweenDates(@RequestParam String nome, @RequestParam String first, @RequestParam String last) {
        return this.transferenciaService.findBetweenDatesAndOperador(nome, first, last);
    }

}
