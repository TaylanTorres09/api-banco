package br.com.banco.services;

import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

import br.com.banco.models.Conta;
import br.com.banco.repositories.ContaRepository;

@SpringBootTest
public class ContaServiceTest {
    
    @InjectMocks
    private ContaService contaService;

    @Mock
    private ContaRepository contaRepository;

    private Conta conta = new Conta();
    private Optional<Conta> optional;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        startConta();
    }

    private void startConta() {
        conta = new Conta(Long.valueOf(1), "Ostrogogildo");
        optional = Optional.of(new Conta(Long.valueOf(1), "Ostrogogildo"));
    }
}
