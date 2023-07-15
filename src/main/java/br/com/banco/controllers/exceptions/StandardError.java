package br.com.banco.controllers.exceptions;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class StandardError {
    
    private Long timestamp;
    private Integer status;
    private String message;

}
