package com.business95.api.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.business95.api.dto.response.BalanceInversionResponse;
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

    @GetMapping("/{idSocio}")
    public ResponseEntity<SocioResponse> socioFindById(@PathVariable Long idSocio) {
        return ResponseEntity.ok().body(socioService.socioFindById(idSocio));
    }

    @GetMapping("/{idSocio}/balance")
    public ResponseEntity<BalanceSocioResponse> balanceSocio(@PathVariable Long idSocio) {
        return ResponseEntity.ok().body(socioService.balanceSocio(idSocio));
    }

    @GetMapping("/{idSocio}/inversiones")
    public ResponseEntity<List<BalanceInversionResponse>> balanceInversionesBySocio(@PathVariable Long idSocio) {
        return ResponseEntity.ok().body(socioService.balanceInversionPorSocio(idSocio));
    }

}
