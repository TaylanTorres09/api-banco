package br.com.banco.controllers;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.aspectj.lang.annotation.After;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import br.com.banco.models.Conta;
import br.com.banco.services.ContaService;

@SpringBootTest
public class ContaControllerTest {

    private static final Long ID = Long.valueOf(1);
    
    private static final String nomeResponsavel = "Ostrogogildo";

    @InjectMocks
    private ContaController contaController;

    @Mock
    private ContaService contaService;

    Conta conta = new Conta();
    Optional<Conta> optional;

    @BeforeEach
    void setUp() {
        MockHttpServletRequest mockRequest = new MockHttpServletRequest();
        ServletRequestAttributes attributes = new ServletRequestAttributes(mockRequest);
        RequestContextHolder.setRequestAttributes(attributes);
        MockitoAnnotations.openMocks(this);
        startConta();
    }

    @After(value = "")
    public void teardown() {
        RequestContextHolder.resetRequestAttributes();
    }

    @Test
    void whenFindByIdStatusOk() {
        when(contaService.findById(anyLong())).thenReturn(conta);

        Conta response = contaController.findById(ID);

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
