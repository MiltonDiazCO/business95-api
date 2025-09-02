package com.business95.api.business95_api.helpers;

import org.springframework.stereotype.Component;

import com.business95.api.business95_api.entities.Categoria;
import com.business95.api.business95_api.exceptions.CategoriaNoEncontradaException;
import com.business95.api.business95_api.repositories.CategoriaRepository;

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
