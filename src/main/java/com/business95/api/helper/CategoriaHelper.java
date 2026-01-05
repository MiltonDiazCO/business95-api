package com.business95.api.helper;

import org.springframework.stereotype.Component;

import com.business95.api.entity.Categoria;
import com.business95.api.exception.CategoriaNoEncontradaException;
import com.business95.api.repository.CategoriaRepository;

@Component
public class CategoriaHelper {

    private CategoriaRepository categoriaRepository;

    public CategoriaHelper(CategoriaRepository categoriaRepository) {
        this.categoriaRepository = categoriaRepository;
    }

    public Categoria findByIdOrThrow(Long idCategoria) {
        return categoriaRepository.findById(idCategoria)
                .orElseThrow(() -> new CategoriaNoEncontradaException(idCategoria));
    }

}
