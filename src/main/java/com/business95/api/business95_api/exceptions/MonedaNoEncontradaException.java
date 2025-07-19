package com.business95.api.business95_api.exceptions;

public class MonedaNoEncontradaException extends RuntimeException {

    public MonedaNoEncontradaException(String moneda) {
        super("La moneda " + moneda + " no se encuentra registrada en el sistema.");
    }

}
