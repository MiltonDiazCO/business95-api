package com.business95.api.business95_api.servicies.implementations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.business95.api.business95_api.entities.Inversion;
import com.business95.api.business95_api.exceptions.InversionNoEncontradaException;
import com.business95.api.business95_api.repositories.InversionRepository;
import com.business95.api.business95_api.servicies.interfaces.InversionService;

@Service
public class InversionServiceImpl implements InversionService {

    @Autowired
    InversionRepository inversionRepository;

    @Override
    public Inversion findById(Long idInversion) {
        return inversionRepository.findById(idInversion)
                .orElseThrow(() -> new InversionNoEncontradaException(idInversion));
    }

    @Override
    public Inversion save(Inversion inversion) {
        return inversionRepository.save(inversion);
    }

    @Override
    public Inversion update(Long idInversion, Inversion inversion) {
        Inversion inversionUpdate = inversionRepository.findById(idInversion)
                .orElseThrow(() -> new InversionNoEncontradaException(idInversion));
        inversionUpdate.setInversion(inversion.getInversion());
        return inversionRepository.save(inversionUpdate);
    }

    @Override
    public void delete(Long idInversion) {
        inversionRepository.findById(idInversion).orElseThrow(() -> new InversionNoEncontradaException(idInversion));
        inversionRepository.deleteById(idInversion);
    }

}
