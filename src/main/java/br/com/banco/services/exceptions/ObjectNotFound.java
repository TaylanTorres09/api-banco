package br.com.banco.services.exceptions;

public class ObjectNotFound extends RuntimeException{
    
    public ObjectNotFound(String msg) {
        super(msg);
    }

}
