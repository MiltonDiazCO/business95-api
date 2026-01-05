package com.business95.api.exception;

public class IdActividadRequeridaException extends RuntimeException {

    public IdActividadRequeridaException() {
        super("El ID de la actividad es requerida");
    }

}
