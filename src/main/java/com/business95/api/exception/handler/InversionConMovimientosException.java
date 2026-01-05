package com.business95.api.exception.handler;

public class InversionConMovimientosException extends RuntimeException {

    public InversionConMovimientosException(Long id) {
        super("La inversión con ID " + id + " tiene movimientos asociados. Por favor, elimine primero dichos movimientos.");
    }

}
