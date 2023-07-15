package br.com.banco.controllers;

import java.util.Optional;

import org.aspectj.lang.annotation.After;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import br.com.banco.models.Conta;
import br.com.banco.services.ContaService;

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

    private void startConta() {
        conta = new Conta(ID, nomeResponsavel);
        optional = Optional.of(new Conta(ID, nomeResponsavel));
    }
}
