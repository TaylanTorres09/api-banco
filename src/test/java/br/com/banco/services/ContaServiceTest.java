package br.com.banco.services;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;

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

    private static final Long ID = Long.valueOf(1);
    
    private static final String nomeResponsavel = "Ostrogogildo";
    
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

    @Test
    void whenFindByIdThenReturnAContaInstance() {
        when(contaRepository.findById(anyLong())).thenReturn(optional);

        Conta response = contaService.findById(ID);

        assertNotNull(response);
        assertEquals(Conta.class, response.getClass());
        assertEquals(ID, response.getIdConta());
        assertEquals(nomeResponsavel, response.getNomeResponsavel());
    }

    private void startConta() {
        conta = new Conta(ID, nomeResponsavel);
        optional = Optional.of(new Conta(ID, nomeResponsavel));
    }
}
