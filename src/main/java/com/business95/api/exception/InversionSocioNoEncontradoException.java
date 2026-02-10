package com.business95.api.exception;

public class InversionSocioNoEncontradoException extends RuntimeException {

    public InversionSocioNoEncontradoException() {
        super("No se encontró el socio para la inversión indicada.");
    }

    

}
