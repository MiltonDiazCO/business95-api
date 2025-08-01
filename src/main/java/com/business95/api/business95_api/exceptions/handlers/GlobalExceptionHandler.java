package com.business95.api.business95_api.exceptions.handlers;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.business95.api.business95_api.exceptions.ActividadSocioNoEncontradaException;
import com.business95.api.business95_api.exceptions.CategoriaNoEncontradaException;
import com.business95.api.business95_api.exceptions.InversionNoEncontradaException;
import com.business95.api.business95_api.exceptions.MedidaNoEncontradaException;
import com.business95.api.business95_api.exceptions.MonedaNoEncontradaException;
import com.business95.api.business95_api.exceptions.MovimientoNoEncontradoException;
import com.business95.api.business95_api.exceptions.SocioNoEncontradoException;
import com.business95.api.business95_api.exceptions.TipoActividadNoEncontradoException;
import com.business95.api.business95_api.utils.ErrorUtils;
import com.fasterxml.jackson.databind.exc.InvalidFormatException;
import com.fasterxml.jackson.databind.exc.MismatchedInputException;

import jakarta.servlet.http.HttpServletRequest;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @Autowired
    private MessageSource messageSource;

    @Autowired
    private MensajeErrorHttpService mensajeErrorHttpService;

    @ExceptionHandler({
            MovimientoNoEncontradoException.class,
            CategoriaNoEncontradaException.class,
            MonedaNoEncontradaException.class,
            MedidaNoEncontradaException.class,
            InversionNoEncontradaException.class,
            SocioNoEncontradoException.class,
            TipoActividadNoEncontradoException.class,
            ActividadSocioNoEncontradaException.class
    })
    public ResponseEntity<ErrorResponse> manejarExcepcionesRecursoNoEncontrado(RuntimeException exc,
            HttpServletRequest request) {

        return ErrorUtils.construirRespuestaErrorExcepcion(
                mensajeErrorHttpService.obtenerMensajePorMetodoHttp(request.getMethod()),
                exc.getMessage(),
                HttpStatus.NOT_FOUND.value(), request);
    }

    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<ErrorResponse> manejarFormatoEntradaInvalido(
            HttpMessageNotReadableException exc,
            HttpServletRequest request) {

        String error = exc.getMessage();

        if (exc.getCause() instanceof InvalidFormatException) {

            InvalidFormatException invalidExc = (InvalidFormatException) exc.getCause();

            if (invalidExc.getTargetType().equals(BigDecimal.class) || invalidExc.getTargetType().equals(Long.class)) {
                error = messageSource.getMessage("error.numero.invalido", null, Locale.getDefault());
            }
        }

        if (exc.getCause() instanceof MismatchedInputException) {

            MismatchedInputException mismatchedExc = (MismatchedInputException) exc.getCause();

            if (mismatchedExc.getTargetType().equals(LocalDateTime.class)) {
                error = messageSource.getMessage("error.fecha.formato.invalido", null, Locale.getDefault());
            }
        }

        return ErrorUtils.construirRespuestaErrorExcepcion(
                messageSource.getMessage("error.formato.invalido", null, Locale.getDefault()),
                error, HttpStatus.BAD_REQUEST.value(), request);
    }

}
