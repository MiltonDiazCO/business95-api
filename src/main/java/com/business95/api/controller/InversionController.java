package com.business95.api.controller;

import java.util.List;
import java.util.Set;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.business95.api.dto.request.ActualizarInversionRequest;
import com.business95.api.dto.request.InversionRequest;
import com.business95.api.dto.request.SocioRolInversionRequest;
import com.business95.api.dto.response.InversionConBalancesSociosResponse;
import com.business95.api.dto.response.InversionResponse;
import com.business95.api.dto.response.PaginaResponse;
import com.business95.api.dto.response.ResumenMovimientoResponse;
import com.business95.api.dto.response.SocioPorInversionResponse;
import com.business95.api.service.interfaces.InversionService;
import com.business95.api.service.interfaces.InversionSocioService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/inversiones")
public class InversionController {

    private final InversionService inversionService;
    private final InversionSocioService inversionSocioService;

    public InversionController(
            InversionService inversionService,
            InversionSocioService inversionSocioService) {
        this.inversionService = inversionService;
        this.inversionSocioService = inversionSocioService;
    }

    @GetMapping("/{idInversion}")
    public ResponseEntity<InversionResponse> buscarInversionPorId(@PathVariable Long idInversion) {
        return ResponseEntity.ok().body(inversionService.inversionPorId(idInversion));
    }

    @GetMapping("/{idInversion}/socios")
    public PaginaResponse<SocioPorInversionResponse> sociosPorInversion(
            @PathVariable Long idInversion, Pageable pageable) {
        return inversionSocioService.sociosPorInversion(idInversion, pageable);
    }

    @GetMapping("/{idInversion}/balance-socios")
    public ResponseEntity<InversionConBalancesSociosResponse> balanceInversionesPorSocio(
            @PathVariable Long idInversion) {
        return ResponseEntity.ok().body(inversionService.balanceSociosPorInversion(idInversion));
    }

    @GetMapping("/{idInversion}/movimientos")
    public ResponseEntity<Page<ResumenMovimientoResponse>> encontrarMovimientosPorInversion(
            @PathVariable Long idInversion,
            @RequestParam(defaultValue = "0") int pagina,
            @RequestParam(defaultValue = "5") int limite) {
        return ResponseEntity.ok().body(inversionService.resumenMovimientosPorInversion(
                idInversion,
                pagina,
                limite));
    }

    @PostMapping
    public ResponseEntity<?> registrarInversion(
            @Valid @RequestBody InversionRequest inversionRequest) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(inversionService.guardarInversionConSocios(inversionRequest));
    }

    @PutMapping("/{idInversion}")
    public ResponseEntity<?> actualizarInversion(
            @PathVariable Long idInversion,
            @Valid @RequestBody ActualizarInversionRequest actualizarInversionRequest) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(inversionService.actualizarDetalleInversion(idInversion, actualizarInversionRequest));
    }

    @DeleteMapping("/{idInversion}")
    public ResponseEntity<?> eliminarInversion(@PathVariable Long idInversion) {
        inversionService.eliminarInversion(idInversion);
        return ResponseEntity.noContent().build();
    }

    @PostMapping("/{idInversion}/socios")
    public ResponseEntity<?> agregarSociosAInversion(
            @PathVariable Long idInversion,
            @RequestBody Set<SocioRolInversionRequest> socios) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(inversionSocioService.agregarSociosAInversion(idInversion, socios));
    }

    @PutMapping("/{idInversion}/socios")
    public ResponseEntity<?> modificarRolesDeSociosEnInversion(
            @PathVariable Long idInversion,
            @RequestBody Set<SocioRolInversionRequest> socios) {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(inversionSocioService.modificarRolesDeSociosEnInversion(idInversion, socios));
    }

    @DeleteMapping("/{idInversion}/socios")
    public ResponseEntity<?> eliminarSociosDeInversion(
            @PathVariable Long idInversion,
            @RequestBody List<Long> socios) {
        inversionSocioService.eliminarSociosDeInversion(idInversion, socios);
        return ResponseEntity.noContent().build();
    }

}
