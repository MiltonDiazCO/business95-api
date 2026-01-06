package com.business95.api.service.implementation;

import java.util.Locale;

import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;

import com.business95.api.service.interfaces.ErroresService;

@Service
public class ErroresServiceImpl implements ErroresService {

    private MessageSource messageSource;

    public ErroresServiceImpl(MessageSource messageSource) {
        this.messageSource = messageSource;
    }

    @Override
    public String obtenerMensajePorMetodoHttp(String metodo) {
        switch (metodo) {
            case "GET":
                return messageSource.getMessage("error.consulta", null, Locale.getDefault());
            case "POST":
                return messageSource.getMessage("error.registro", null, Locale.getDefault());
            case "PUT":
                return messageSource.getMessage("error.actualizacion", null, Locale.getDefault());
            case "DELETE":
                return messageSource.getMessage("error.eliminacion", null, Locale.getDefault());
            default:
                return messageSource.getMessage("error.operacion.invalida", null, Locale.getDefault());
        }
    }

}
