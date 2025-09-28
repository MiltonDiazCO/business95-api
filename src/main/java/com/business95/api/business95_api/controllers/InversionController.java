package com.business95.api.business95_api.controllers;

import java.util.List;
import java.util.Locale;

import org.springframework.context.MessageSource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.business95.api.business95_api.dtos.responses.InversionRes;
import com.business95.api.business95_api.dtos.responses.InversionSociosRes;
import com.business95.api.business95_api.dtos.requests.InversionRequest;
import com.business95.api.business95_api.dtos.responses.BalanceInversionRes;
import com.business95.api.business95_api.dtos.responses.BalanceMovsPorInvRes;
import com.business95.api.business95_api.entities.Inversion;
import com.business95.api.business95_api.servicies.interfaces.InversionService;
import com.business95.api.business95_api.utils.ErrorUtils;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/inversiones")
public class InversionController {

    private final InversionService inversionService;
    private final MessageSource messageSource;

    public InversionController(InversionService inversionService, MessageSource messageSource) {
        this.inversionService = inversionService;
        this.messageSource = messageSource;
    }

    @GetMapping("/{idInversion}")
    public ResponseEntity<InversionRes> inversionFindById(@PathVariable Long idInversion) {
        return ResponseEntity.ok().body(inversionService.inversionPorId(idInversion));
    }

    @GetMapping("/{idInversion}/socios")
    public ResponseEntity<InversionSociosRes> sociosPorInversion(@PathVariable Long idInversion) {
        return ResponseEntity.ok().body(inversionService.sociosPorInversion(idInversion));
    }

    @GetMapping("/{idInversion}/balance")
    public ResponseEntity<BalanceInversionRes> balanceInversionesPorSocio(@PathVariable Long idInversion) {
        return ResponseEntity.ok().body(inversionService.balanceInversion(idInversion));
    }

    @GetMapping("/{idInversion}/movimientos")
    public ResponseEntity<List<BalanceMovsPorInvRes>> findMovimientosPorInversion(
            @PathVariable Long idInversion) {
        return ResponseEntity.ok().body(inversionService.balanceMovimientosPorInversion(idInversion));
    }

    @PostMapping
    public ResponseEntity<?> registrarInversion(
            @Valid @RequestBody InversionRequest inversionRequest,
            BindingResult result,
            HttpServletRequest request) {

        if (result.hasErrors()) {
            return ErrorUtils.construirRespuestaErrorValidacion(
                    messageSource.getMessage("error.registro", null, Locale.getDefault()),
                    result, HttpStatus.BAD_REQUEST.value(), request);
        }
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(inversionService.guardarInversionConSocios(inversionRequest));
    }

    @PostMapping("/{idInversion}/socios")
    public ResponseEntity<?> agregarSociosAInversion(
            @PathVariable Long idInversion,
            @RequestBody List<Long> socios) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(inversionService.agregarSociosAInversion(idInversion, socios));
    }

    @PutMapping("/{idInversion}")
    public ResponseEntity<?> actualizarInversion(
            @PathVariable Long idInversion,
            @Valid @RequestBody Inversion inversion,
            BindingResult result,
            HttpServletRequest request) {

        if (result.hasErrors()) {

            return ErrorUtils.construirRespuestaErrorValidacion(
                    messageSource.getMessage("error.actualizacion", null, Locale.getDefault()),
                    result, HttpStatus.BAD_REQUEST.value(), request);
        }
        return ResponseEntity.status(HttpStatus.CREATED).body(inversionService.update(idInversion, inversion));
    }

    @DeleteMapping("/{idInversion}")
    public ResponseEntity<?> eliminarInversion(@PathVariable Long idInversion) {
        inversionService.delete(idInversion);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{idInversion}/socios")
    public ResponseEntity<?> eliminarSociosDeInversion(
            @PathVariable Long idInversion,
            @RequestBody List<Long> socios) {
        inversionService.eliminarSociosDeInversion(idInversion, socios);
        return ResponseEntity.noContent().build();
    }

}
