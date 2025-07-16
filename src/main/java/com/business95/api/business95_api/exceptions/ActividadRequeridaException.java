package com.business95.api.business95_api.exceptions;

public class ActividadRequeridaException extends RuntimeException {

    public ActividadRequeridaException() {
        super("El movimiento debe tener al menos una actividad asociada");
    }

}
