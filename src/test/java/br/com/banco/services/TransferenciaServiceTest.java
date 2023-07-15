package br.com.banco.services;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

import br.com.banco.models.Conta;
import br.com.banco.models.Transferencia;
import br.com.banco.repositories.TransferenciaRepository;

@SpringBootTest
public class TransferenciaServiceTest {

    private static final DateTimeFormatter fmt = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
    private static final Long ID = Long.valueOf(1);
    private static final String nomeResponsavel = "Ostrogogildo";
    private static final LocalDateTime dataTransferencia = LocalDateTime.parse("2019-01-01 12:00:00", fmt);
    private static final Double valor = 30895.46;
    private static final String tipo = "DEPOSITO";
    private static final String nomeOperadorTransacao = "Donatello";

    @InjectMocks
    private TransferenciaService transferenciaService;

    @Mock
    private TransferenciaRepository transferenciaRepository;

    @Mock
    private ContaService contaService;

    private Conta conta = new Conta();
    private Transferencia transferencia = new Transferencia();
    List<Transferencia> transferencias;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        startContaTransferencia();
    }

    @Test
    void whenFindByIdTheReturnListTransferencia() {
        when(transferenciaRepository.findByContaId(anyLong())).thenReturn(transferencias);
        when(contaService.findById(anyLong())).thenReturn(conta);

        List<Transferencia> response = transferenciaService.findByContaId(ID);

        assertNotNull(response);
        assertEquals(Transferencia.class, response.get(0).getClass());
        assertEquals(ID, response.get(0).getId());
        assertEquals(dataTransferencia, response.get(0).getDataTransferencia());
        assertEquals(valor, response.get(0).getValor());
        assertEquals(tipo, response.get(0).getTipo());
        assertEquals(nomeOperadorTransacao, response.get(0).getNomeOperadorTransacao());
        assertEquals(conta.getClass(), response.get(0).getConta().getClass());
        assertEquals(conta.getIdConta(), response.get(0).getConta().getIdConta());
        assertEquals(conta.getNomeResponsavel(), response.get(0).getConta().getNomeResponsavel());
    }

    @Test
    void whenFindAll() {
        when(transferenciaRepository.findAll()).thenReturn(transferencias);

        List<Transferencia> response = transferenciaService.findAll();

        assertNotNull(response);
        assertEquals(Transferencia.class, response.get(0).getClass());
        assertEquals(ID, response.get(0).getId());
        assertEquals(dataTransferencia, response.get(0).getDataTransferencia());
        assertEquals(valor, response.get(0).getValor());
        assertEquals(tipo, response.get(0).getTipo());
        assertEquals(nomeOperadorTransacao, response.get(0).getNomeOperadorTransacao());
        assertEquals(conta.getClass(), response.get(0).getConta().getClass());
        assertEquals(conta.getIdConta(), response.get(0).getConta().getIdConta());
        assertEquals(conta.getNomeResponsavel(), response.get(0).getConta().getNomeResponsavel());
    }

    @Test
    void whenFindByNomeOperadorThenReturnTransferencias() {
        when(transferenciaRepository.findByNomeOperador(anyString())).thenReturn(transferencias);

        List<Transferencia> response = transferenciaService.findByNomeOperador(nomeOperadorTransacao);

        assertNotNull(response);
        assertEquals(Transferencia.class, response.get(0).getClass());
        assertEquals(ID, response.get(0).getId());
        assertEquals(dataTransferencia, response.get(0).getDataTransferencia());
        assertEquals(valor, response.get(0).getValor());
        assertEquals(tipo, response.get(0).getTipo());
        assertEquals(nomeOperadorTransacao, response.get(0).getNomeOperadorTransacao());
        assertEquals(conta.getClass(), response.get(0).getConta().getClass());
        assertEquals(conta.getIdConta(), response.get(0).getConta().getIdConta());
        assertEquals(conta.getNomeResponsavel(), response.get(0).getConta().getNomeResponsavel());
    }

    @Test
    void whenFindBetweenDatesThenReturnTransferencias() {
        when(transferenciaRepository.findBetweenDates(any(), any())).thenReturn(transferencias);

        List<Transferencia> response = transferenciaService.findBetweenDates("2019-01-01 12:00:00", "2019-01-01 12:00:00");

        assertNotNull(response);
        assertEquals(Transferencia.class, response.get(0).getClass());
        assertEquals(ID, response.get(0).getId());
        assertEquals(dataTransferencia, response.get(0).getDataTransferencia());
        assertEquals(valor, response.get(0).getValor());
        assertEquals(tipo, response.get(0).getTipo());
        assertEquals(nomeOperadorTransacao, response.get(0).getNomeOperadorTransacao());
        assertEquals(conta.getClass(), response.get(0).getConta().getClass());
        assertEquals(conta.getIdConta(), response.get(0).getConta().getIdConta());
        assertEquals(conta.getNomeResponsavel(), response.get(0).getConta().getNomeResponsavel());
    }

    private void startContaTransferencia() {
        conta = new Conta(ID, nomeResponsavel);
        transferencia = new Transferencia(ID, dataTransferencia, valor, tipo, nomeOperadorTransacao, conta);
        transferencias = List.of(new Transferencia(ID, dataTransferencia, valor, tipo, nomeOperadorTransacao, conta));
    }
}
