package com.business95.api.business95_api.utils;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;

import com.business95.api.business95_api.exceptions.handlers.ErrorResponse;

import jakarta.servlet.http.HttpServletRequest;

public class ErrorUtils {

    private static ErrorResponse construirErrorResponse(
            String mensaje,
            List<String> errores,
            int httpStatusCode,
            HttpServletRequest request) {

        ErrorResponse errorResponse = new ErrorResponse();

        errorResponse.setMensaje(mensaje);
        errorResponse.setErrores(errores);
        errorResponse.setCodigoEstado(httpStatusCode);
        errorResponse.setRuta(request.getRequestURI());
        errorResponse.setFecha(LocalDateTime.now());

        return errorResponse;
    }

    public static ResponseEntity<ErrorResponse> construirRespuestaErrorExcepcion(
            String mensaje,
            String errorExcepcion,
            int httpStatusCode,
            HttpServletRequest request) {

        ErrorResponse errorResponse = construirErrorResponse(mensaje,
                Arrays.asList(errorExcepcion),
                httpStatusCode, request);

        return ResponseEntity.status(httpStatusCode).body(errorResponse);
    }

    public static ResponseEntity<ErrorResponse> construirRespuestaErrorValidacion(
            String mensaje,
            BindingResult result,
            int httpStatusCode,
            HttpServletRequest request) {

        Map<String, String> errores = new HashMap<>();

        result.getFieldErrors().forEach(error -> {
            errores.put(error.getField(), error.getDefaultMessage());
        });

        ErrorResponse errorResponse = construirErrorResponse(mensaje,
                List.copyOf(errores.values()),
                httpStatusCode, request);

        return ResponseEntity.status(httpStatusCode).body(errorResponse);
    }

}
