package com.business95.api.business95_api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.business95.api.business95_api.dtos.responses.SocioResponseDTO;
import com.business95.api.business95_api.servicies.interfaces.SocioService;

@RestController()
@RequestMapping("/socios")
public class SocioController {

    @Autowired
    private SocioService socioService;

    @GetMapping("/{idSocio}")
    public SocioResponseDTO socioFindById(@PathVariable Long idSocio) {
        return socioService.socioFindById(idSocio);
    }

}
