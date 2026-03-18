package com.business95.api.dto.response;

import java.util.List;

import org.springframework.data.domain.Page;

public class PaginaResponse<T> {

    private List<T> contenido;

    // Paginación
    private int pagina;
    private int limite;
    private int elementosEnPagina;
    private int totalPaginas;
    private long totalElementos;

    // Estado
    private boolean esPrimeraPagina;
    private boolean esUltimaPagina;

    public PaginaResponse(Page<T> page) {
        this.contenido = page.getContent();
        this.pagina = page.getNumber();
        this.limite = page.getSize();
        this.elementosEnPagina = page.getNumberOfElements();
        this.totalPaginas = page.getTotalPages();
        this.totalElementos = page.getTotalElements();
        this.esPrimeraPagina = page.isFirst();
        this.esUltimaPagina = page.isLast();
    }

    public List<T> getContenido() {
        return contenido;
    }

    public void setContenido(List<T> contenido) {
        this.contenido = contenido;
    }

    public int getPagina() {
        return pagina;
    }

    public void setPagina(int pagina) {
        this.pagina = pagina;
    }

    public int getLimite() {
        return limite;
    }

    public void setLimite(int limite) {
        this.limite = limite;
    }

    public int getElementosEnPagina() {
        return elementosEnPagina;
    }

    public void setElementosEnPagina(int elementosEnPagina) {
        this.elementosEnPagina = elementosEnPagina;
    }

    public int getTotalPaginas() {
        return totalPaginas;
    }

    public void setTotalPaginas(int totalPaginas) {
        this.totalPaginas = totalPaginas;
    }

    public long getTotalElementos() {
        return totalElementos;
    }

    public void setTotalElementos(long totalElementos) {
        this.totalElementos = totalElementos;
    }

    public boolean isEsPrimeraPagina() {
        return esPrimeraPagina;
    }

    public void setEsPrimeraPagina(boolean esPrimeraPagina) {
        this.esPrimeraPagina = esPrimeraPagina;
    }

    public boolean isEsUltimaPagina() {
        return esUltimaPagina;
    }

    public void setEsUltimaPagina(boolean esUltimaPagina) {
        this.esUltimaPagina = esUltimaPagina;
    }

}