package com.business95.api.business95_api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.business95.api.business95_api.dtos.responses.BalanceSocioRes;
import com.business95.api.business95_api.dtos.responses.SocioRes;
import com.business95.api.business95_api.servicies.interfaces.SocioService;

@RestController()
@RequestMapping("/socios")
public class SocioController {

    @Autowired
    private SocioService socioService;

    @GetMapping("/{idSocio}")
    public ResponseEntity<SocioRes> socioFindById(@PathVariable Long idSocio) {
        return ResponseEntity.ok().body(socioService.socioFindById(idSocio));
    }

    @GetMapping("/{idSocio}/balance")
    public ResponseEntity<BalanceSocioRes> balanceSocio(@PathVariable Long idSocio) {
        return ResponseEntity.ok().body(socioService.balanceSocio(idSocio));
    }

}
