package br.gov.caixa.adabankapi.exceptions;

public class ValidationException extends RuntimeException {

    public ValidationException(String msg) {

        super(msg);
    }

}