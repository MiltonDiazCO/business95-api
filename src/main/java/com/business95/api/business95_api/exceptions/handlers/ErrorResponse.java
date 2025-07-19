package com.business95.api.business95_api.exceptions.handlers;

import java.time.LocalDateTime;
import java.util.List;

public class ErrorResponse {

    private String mensaje;
    private List<String> errores;
    private int codigoEstado;
    private String ruta;
    private LocalDateTime fecha;

    public ErrorResponse() {
    }

    public ErrorResponse(String mensaje, int codigoEstado, String ruta, LocalDateTime fecha) {
        this.mensaje = mensaje;
        this.codigoEstado = codigoEstado;
        this.ruta = ruta;
        this.fecha = fecha;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public int getCodigoEstado() {
        return codigoEstado;
    }

    public void setCodigoEstado(int codigoEstado) {
        this.codigoEstado = codigoEstado;
    }

    public String getRuta() {
        return ruta;
    }

    public void setRuta(String ruta) {
        this.ruta = ruta;
    }

    public LocalDateTime getFecha() {
        return fecha;
    }

    public void setFecha(LocalDateTime fecha) {
        this.fecha = fecha;
    }

    public List<String> getErrores() {
        return errores;
    }

    public void setErrores(List<String> errores) {
        this.errores = errores;
    }

}
