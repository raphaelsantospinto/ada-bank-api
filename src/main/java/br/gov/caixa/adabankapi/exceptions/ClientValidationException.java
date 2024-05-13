package br.gov.caixa.adabankapi.exceptions;

public class ClientValidationException extends RuntimeException {

    public ClientValidationException(String msg) {

        super(msg);
    }

}