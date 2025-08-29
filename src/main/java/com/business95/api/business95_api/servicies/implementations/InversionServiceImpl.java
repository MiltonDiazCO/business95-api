package com.business95.api.business95_api.servicies.implementations;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.business95.api.business95_api.dtos.responses.InversionResponseDTO;
import com.business95.api.business95_api.entities.Inversion;
import com.business95.api.business95_api.exceptions.InversionNoEncontradaException;
import com.business95.api.business95_api.repositories.InversionRepository;
import com.business95.api.business95_api.servicies.interfaces.InversionService;

@Service
public class InversionServiceImpl implements InversionService {

    private final InversionRepository inversionRepository;

    public InversionServiceImpl(InversionRepository inversionRepository) {
        this.inversionRepository = inversionRepository;
    }

    @Override
    @Transactional(readOnly = true)
    public Inversion findById(Long idInversion) {
        return inversionRepository.findById(idInversion)
                .orElseThrow(() -> new InversionNoEncontradaException(idInversion));
    }

    @Override
    @Transactional(readOnly = true)
    public InversionResponseDTO inversionFindById(Long idInversion) {
        Inversion inversion = findById(idInversion);

        InversionResponseDTO inversionResponseDTO = new InversionResponseDTO();

        inversionResponseDTO.setIdInversion(inversion.getIdInversion());
        inversionResponseDTO.setInversion(inversion.getInversion());

        return inversionResponseDTO;
    }

    @Override
    @Transactional()
    public Inversion save(Inversion inversion) {
        return inversionRepository.save(inversion);
    }

    @Override
    @Transactional()
    public Inversion update(Long idInversion, Inversion inversion) {

        Inversion inversionUpdate = inversionRepository.findById(idInversion)
                .orElseThrow(() -> new InversionNoEncontradaException(idInversion));

        inversionUpdate.setInversion(inversion.getInversion());
        return inversionRepository.save(inversionUpdate);
    }

    @Override
    @Transactional()
    public void delete(Long idInversion) {

        inversionRepository.findById(idInversion)
                .orElseThrow(() -> new InversionNoEncontradaException(idInversion));

        inversionRepository.deleteById(idInversion);
    }

}
