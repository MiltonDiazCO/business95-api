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

    public static List<String> construirErroresDeExcepcion(String errorExcepcion) {
        return Arrays.asList(errorExcepcion);
    }

    public static List<String> construirErroresDeValidacion(BindingResult result) {

        Map<String, String> errores = new HashMap<>();

        result.getFieldErrors().forEach(error -> {
            errores.put(error.getField(), error.getDefaultMessage());
        });

        return List.copyOf(errores.values());
    }

    public static ResponseEntity<ErrorHttpResponse> construirErrorResponse(
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

        return ResponseEntity.status(httpStatusCode).body(errorHttpResponse);
    }

}
