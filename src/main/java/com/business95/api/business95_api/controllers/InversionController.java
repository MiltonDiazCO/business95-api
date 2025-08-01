package com.business95.api.business95_api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.business95.api.business95_api.entities.Inversion;
import com.business95.api.business95_api.servicies.interfaces.InversionService;
import com.business95.api.business95_api.utils.ErrorUtils;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/inversiones")
public class InversionController {

    @Autowired
    private InversionService inversionService;

    @PostMapping
    public ResponseEntity<?> registrarInversion(@Valid @RequestBody Inversion inversion,
            BindingResult result,
            HttpServletRequest request) {
        if (result.hasErrors()) {
            return ErrorUtils.construirRespuestaErrorValidacion(result, request, "Error al registrar la inversión.");
        }
        return ResponseEntity.status(HttpStatus.CREATED).body(inversionService.save(inversion));
    }

    @PutMapping("/{idInversion}")
    public ResponseEntity<?> actualizarInversion(@PathVariable Long idInversion,
            @Valid @RequestBody Inversion inversion,
            BindingResult result,
            HttpServletRequest request) {
        if (result.hasErrors()) {
            return ErrorUtils.construirRespuestaErrorValidacion(result, request, "Error al actualizar la inversión.");
        }
        return ResponseEntity.status(HttpStatus.CREATED).body(inversionService.update(idInversion, inversion));
    }

    @DeleteMapping("/{idInversion}")
    public ResponseEntity<?> eliminarInversion(@PathVariable Long idInversion) {
        inversionService.delete(idInversion);
        return ResponseEntity.noContent().build();
    }

}
