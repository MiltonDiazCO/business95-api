package com.business95.api.controller;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.business95.api.dto.response.InversionConBalancesSociosResponse;
import com.business95.api.dto.response.MovimientoRecienteResponse;
import com.business95.api.dto.response.SocioNombresResponse;
import com.business95.api.dto.response.ActividadRecienteResponse;
import com.business95.api.dto.response.BalanceSocioResponse;
import com.business95.api.dto.response.SocioResponse;
import com.business95.api.service.interfaces.SocioService;

@RestController()
@RequestMapping("/socios")
public class SocioController {

    private SocioService socioService;

    public SocioController(SocioService socioService) {
        this.socioService = socioService;
    }

    @GetMapping("/detalle")
    public ResponseEntity<SocioResponse> detalleSocio() {
        return ResponseEntity.ok().body(socioService.detalleSocio());
    }

    @GetMapping("/balance")
    public ResponseEntity<BalanceSocioResponse> balanceSocio() {
        return ResponseEntity.ok().body(socioService.balanceSocio());
    }

    @GetMapping("/inversiones")
    public ResponseEntity<List<InversionConBalancesSociosResponse>> balanceInversionesPorSocio() {
        return ResponseEntity.ok().body(socioService.balanceInversionesPorSocio());
    }

    @GetMapping("/movimientos")
    public ResponseEntity<Page<MovimientoRecienteResponse>> movimientosRecientes(
            @RequestParam(defaultValue = "0") int pagina,
            @RequestParam(defaultValue = "10") int limite) {
        return ResponseEntity.ok().body(socioService.movimientosRecientes(pagina, limite));
    }

    @GetMapping("/actividades")
    public ResponseEntity<Page<ActividadRecienteResponse>> actividadesRecientes(
            @RequestParam(defaultValue = "0") int pagina,
            @RequestParam(defaultValue = "10") int limite) {
        return ResponseEntity.ok().body(socioService.actividadesRecientes(pagina, limite));
    }

    @GetMapping("/{idSocio}/nombres")
    public ResponseEntity<SocioNombresResponse> obtenerNombresSocioPorId(@PathVariable Long idSocio) {
        return ResponseEntity.ok().body(socioService.nombresSocio(idSocio));
    }

}
