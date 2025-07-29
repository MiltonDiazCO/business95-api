package com.business95.api.business95_api.utils;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;

import com.business95.api.business95_api.exceptions.handlers.ErrorResponse;

import jakarta.servlet.http.HttpServletRequest;

public class ErrorUtils {

    public static ResponseEntity<ErrorResponse> construirRespuestaErrorValidacion(BindingResult result,
            HttpServletRequest request, String mensaje) {

        Map<String, String> errores = new HashMap<>();
        result.getFieldErrors().forEach(error -> {
            errores.put(error.getField(), error.getDefaultMessage());
        });

        ErrorResponse errorResponse = new ErrorResponse();

        errorResponse.setMensaje(mensaje);
        errorResponse.setErrores(List.copyOf(errores.values()));
        errorResponse.setCodigoEstado(HttpStatus.BAD_REQUEST.value());
        errorResponse.setRuta(request.getRequestURI());
        errorResponse.setFecha(LocalDateTime.now());

        return ResponseEntity.badRequest().body(errorResponse);
    }

}
