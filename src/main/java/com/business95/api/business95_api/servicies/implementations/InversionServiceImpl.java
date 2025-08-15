package com.business95.api.business95_api.servicies.implementations;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.business95.api.business95_api.dtos.projections.MovimientoPorInversionConsultaDTO;
import com.business95.api.business95_api.dtos.responses.InversionResponseDTO;
import com.business95.api.business95_api.dtos.responses.MovimientoPorInversionResponseDTO;
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
    @Transactional(readOnly = true)
    public InversionResponseDTO inversionFindById(Long idInversion) {
        Inversion inversion = findById(idInversion);

        InversionResponseDTO inversionResponseDTO = new InversionResponseDTO();

        inversionResponseDTO.setIdInversion(inversion.getIdInversion());
        inversionResponseDTO.setInversion(inversion.getInversion());

        return inversionResponseDTO;
    }

    @Override
    @Transactional(readOnly = true)
    public List<MovimientoPorInversionResponseDTO> findMovimientosPorInversion(Long idInversion) {

        List<MovimientoPorInversionResponseDTO> movimientosPorInversionResponseDTO = new ArrayList<>();
        Iterable<MovimientoPorInversionConsultaDTO> movimientosPorInversionConsultaDTO = inversionRepository
                .findMovimientosPorInversion(idInversion);

        for (MovimientoPorInversionConsultaDTO movimientoPorInversionConsultaDTO : movimientosPorInversionConsultaDTO) {
            MovimientoPorInversionResponseDTO movimientoPorInversionResponseDTO = new MovimientoPorInversionResponseDTO();
            movimientoPorInversionResponseDTO
                    .setIdMovimiento(movimientoPorInversionConsultaDTO.getIdMovimiento());
            movimientoPorInversionResponseDTO
                    .setCategoria(movimientoPorInversionConsultaDTO.getCategoria());
            movimientoPorInversionResponseDTO.setConcepto(movimientoPorInversionConsultaDTO.getConcepto());
            movimientoPorInversionResponseDTO.setCantidad(movimientoPorInversionConsultaDTO.getCantidad());
            movimientoPorInversionResponseDTO.setMedida(movimientoPorInversionConsultaDTO.getMedida());
            movimientoPorInversionResponseDTO.setBalance(movimientoPorInversionConsultaDTO.getBalance());
            movimientoPorInversionResponseDTO.setMoneda(movimientoPorInversionConsultaDTO.getMoneda());
            movimientoPorInversionResponseDTO.setFechaUltimaActividad(
                    movimientoPorInversionConsultaDTO.getFechaUltimaActividad());
            movimientosPorInversionResponseDTO.add(movimientoPorInversionResponseDTO);
        }
        return movimientosPorInversionResponseDTO;
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
