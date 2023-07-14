package br.com.banco.dtos;

import java.time.LocalDateTime;

import javax.validation.constraints.Digits;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.Data;

@Data
public class TransferenciaDTO {
    
    private Long id;

    @NotNull
    private LocalDateTime dataTransferencia;

    @NotNull(message = "valor e obrigatorio")
    @Digits(integer = 20, fraction = 2)
    private Double valor;

    @NotEmpty(message = "tipo obrigatorio")
    private String tipo;

    @Size(min = 0, max = 50)
    private String nomeOperadorTransacao;

    private Long contaId;

}
