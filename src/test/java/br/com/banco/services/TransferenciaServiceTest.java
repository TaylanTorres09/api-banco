package br.com.banco.services;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
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

    private Conta conta = new Conta();
    private Transferencia transferencia = new Transferencia();
    List<Transferencia> transferencias;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        startContaTransferencia();
    }

    private void startContaTransferencia() {
        conta = new Conta(ID, nomeResponsavel);
        transferencia = new Transferencia(ID, dataTransferencia, valor, tipo, nomeOperadorTransacao, conta);
        transferencias = List.of(new Transferencia(ID, dataTransferencia, valor, tipo, nomeOperadorTransacao, conta));
    }
}
