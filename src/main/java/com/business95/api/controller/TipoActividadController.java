package com.business95.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.business95.api.entity.TipoActividad;
import com.business95.api.service.interfaces.TipoActividadService;

@RestController
@RequestMapping("/tipo-actividades")
public class TipoActividadController {

    @Autowired
    private TipoActividadService tipoActividadService;

    @GetMapping
    public List<TipoActividad> tipoActividades() {
        return tipoActividadService.findAll();
    }

    @GetMapping({ "/{idTipoActividad}" })
    public TipoActividad tipoActividadPorID(@PathVariable Long idTipoActividad) {
        return tipoActividadService.findByIdOrThrow(idTipoActividad);
    }

}
