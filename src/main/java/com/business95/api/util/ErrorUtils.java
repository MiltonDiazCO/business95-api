package com.business95.api.util;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;

import com.business95.api.dto.response.ErrorHttpResponse;

import jakarta.servlet.http.HttpServletRequest;

public class ErrorUtils {

    private static ErrorHttpResponse construirErrorResponse(
            String mensaje,
            List<String> errores,
            int httpStatusCode,
            HttpServletRequest request) {

        ErrorHttpResponse errorHttpResponse = new ErrorHttpResponse();

        errorHttpResponse.setMensaje(mensaje);
        errorHttpResponse.setErrores(errores);
        errorHttpResponse.setCodigoEstado(httpStatusCode);
        errorHttpResponse.setRuta(request.getRequestURI());
        errorHttpResponse.setFecha(LocalDateTime.now());

        return errorHttpResponse;
    }
    
    public static ResponseEntity<ErrorHttpResponse> construirRespuestaDeErrorDeExcepcion(
            String mensaje,
            String errorExcepcion,
            int httpStatusCode,
            HttpServletRequest request) {

        ErrorHttpResponse errorHttpResponse = construirErrorResponse(mensaje,
                Arrays.asList(errorExcepcion),
                httpStatusCode, request);

        return ResponseEntity.status(httpStatusCode).body(errorHttpResponse);
    }

    
    public static ResponseEntity<ErrorHttpResponse> construirRespuestaDeErrorDeValidacion(
            String mensaje,
            BindingResult result,
            int httpStatusCode,
            HttpServletRequest request) {

        Map<String, String> errores = new HashMap<>();

        result.getFieldErrors().forEach(error -> {
            errores.put(error.getField(), error.getDefaultMessage());
        });

        ErrorHttpResponse errorHttpResponse = construirErrorResponse(mensaje,
                List.copyOf(errores.values()),
                httpStatusCode, request);

        return ResponseEntity.status(httpStatusCode).body(errorHttpResponse);
    }

}
