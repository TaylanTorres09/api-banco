package br.com.banco.dtos;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import lombok.Data;

@Data
public class ContaDTO {
    
    private Long id;

    @NotEmpty(message = "Nome do responsavel obrigatorio")
    @Size(max = 50, message = "Maximo 50 characteres")
    private String nomeResponsavel;

    public ContaDTO(String nomeResponsavel) {
        this.nomeResponsavel = nomeResponsavel;
    }

}
