package com.business95.api.business95_api.exceptions;

public class SociosRequeridosException extends RuntimeException {

    public SociosRequeridosException() {
        super("Debe asociar por lo menos un socio.");
    }

}
