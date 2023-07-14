package br.com.banco.services;

import java.time.LocalDateTime;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.banco.models.Conta;
import br.com.banco.models.Transferencia;
import br.com.banco.repositories.ContaRepository;
import br.com.banco.repositories.TransferenciaRepository;

@Service
public class StartDBService {

    @Autowired
    private ContaRepository contaRepository;

    @Autowired
    private TransferenciaRepository transferenciaRepository;

    public void instatiateDataBase(){
        Conta contaFulano = new Conta(null, "Fulano");
        Conta contaSicrano = new Conta(null, "Sicrano");

        Transferencia transferencia1 = new Transferencia(null, LocalDateTime.parse("2019-01-01 12:00:00+03"), 30895.46, "DEPOSITO", null, contaFulano);
        Transferencia transferencia2 = new Transferencia(null, LocalDateTime.parse("2019-02-03 09:53:27+03"), 12.24, "DEPOSITO", null, contaSicrano);
        Transferencia transferencia3 = new Transferencia(null, LocalDateTime.parse("2019-05-04 08:12:45+03"), -500.50, "SAQUE", null, contaFulano);
        Transferencia transferencia4 = new Transferencia(null, LocalDateTime.parse("2019-08-07 08:12:45+03"), -530.50, "SAQUE", null, contaSicrano);
        Transferencia transferencia5 = new Transferencia(null, LocalDateTime.parse("2020-06-08 10:15:01+03"), 3241.23, "TRANSFERENCIA", "Beltrano", contaFulano);
        Transferencia transferencia6 = new Transferencia(null, LocalDateTime.parse("2021-04-01 12:12:04+03"), 25173.09, "TRANSFERENCIA", "Ronnyscley", contaSicrano);

        this.contaRepository.saveAll(Arrays.asList(contaFulano, contaSicrano));
        this.transferenciaRepository.saveAll(Arrays.asList(transferencia1, transferencia2, transferencia3, transferencia4, transferencia5, transferencia6));
    }
}
