package com.business95.api.business95_api.exceptions;

public class ActividadRequeridaException extends RuntimeException {

    public ActividadRequeridaException() {
        super("La lista de actividades no puede estar vacía y debe contener al menos una actividad asociada.");
    }

}
