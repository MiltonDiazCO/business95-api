package com.business95.api.exception;

public class SociosRequeridosException extends RuntimeException {

    public SociosRequeridosException() {
        super("Debe asociar por lo menos un socio.");
    }

}
