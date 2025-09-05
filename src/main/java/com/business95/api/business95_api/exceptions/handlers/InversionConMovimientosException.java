package com.business95.api.business95_api.exceptions.handlers;

public class InversionConMovimientosException extends RuntimeException {

    public InversionConMovimientosException(Long id) {
        super("La inversión con ID " + id + " tiene movimientos asociados. Por favor, elimine primero dichos movimientos.");
    }

}
