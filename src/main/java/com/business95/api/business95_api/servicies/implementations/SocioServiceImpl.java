package com.business95.api.business95_api.servicies.implementations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.business95.api.business95_api.dtos.responses.SocioResponseDTO;
import com.business95.api.business95_api.entities.Socio;
import com.business95.api.business95_api.exceptions.SocioNoEncontradoException;
import com.business95.api.business95_api.repositories.SocioRepository;
import com.business95.api.business95_api.servicies.interfaces.SocioService;

@Service
public class SocioServiceImpl implements SocioService {

    @Autowired
    private SocioRepository socioRepository;

    @Override
    public SocioResponseDTO socioFindById(Long idSocio) {

        Socio socio = socioRepository.findById(idSocio).orElseThrow(() -> new SocioNoEncontradoException(idSocio));

        SocioResponseDTO socioResponseDTO = new SocioResponseDTO();

        socioResponseDTO.setIdSocio(socio.getIdSocio());
        socioResponseDTO.setSocio(socio.getNombresRazonsocial() + " " + socio.getApellidos());
        socioResponseDTO.setTelefono(socio.getTelefono());
        socioResponseDTO.setCorreoElectronico(socio.getCorreoElectronico());
        socioResponseDTO.setTipoPersona(socio.getTipoPersona().getTipoPersona());

        return socioResponseDTO;
    }

}
