package com.business95.api.exception;

public class MonedaNoEncontradaException extends RuntimeException {

    public MonedaNoEncontradaException(String moneda) {
        super("La moneda " + moneda + " no se encuentra registrada en el sistema.");
    }

}
