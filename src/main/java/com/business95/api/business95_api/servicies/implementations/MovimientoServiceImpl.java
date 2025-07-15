package com.business95.api.business95_api.servicies.implementations;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.business95.api.business95_api.dto.ActividadDTO;
import com.business95.api.business95_api.dto.MovimientoDTO;
import com.business95.api.business95_api.entities.ActividadSocio;
import com.business95.api.business95_api.entities.Categoria;
import com.business95.api.business95_api.entities.Inversion;
import com.business95.api.business95_api.entities.Medida;
import com.business95.api.business95_api.entities.Moneda;
import com.business95.api.business95_api.entities.Movimiento;
import com.business95.api.business95_api.entities.Socio;
import com.business95.api.business95_api.entities.TipoActividad;
import com.business95.api.business95_api.repositories.CategoriaRepository;
import com.business95.api.business95_api.repositories.InversionRepository;
import com.business95.api.business95_api.repositories.MedidaRepository;
import com.business95.api.business95_api.repositories.MonedaRepository;
import com.business95.api.business95_api.repositories.MovimientoRepository;
import com.business95.api.business95_api.repositories.SocioRepository;
import com.business95.api.business95_api.repositories.TipoActividadRepository;
import com.business95.api.business95_api.servicies.interfaces.MovimientoService;

@Service
public class MovimientoServiceImpl implements MovimientoService {

    @Autowired
    private MovimientoRepository movimientoRepository;

    @Autowired
    private InversionRepository inversionRepository;

    @Autowired
    private CategoriaRepository categoriaRepository;

    @Autowired
    private MonedaRepository monedaRepository;

    @Autowired
    private MedidaRepository medidaRepository;

    @Autowired
    private SocioRepository socioRepository;

    @Autowired
    private TipoActividadRepository tipoActividadRepository;

    @Override
    @Transactional(readOnly = true)
    public List<Movimiento> findAll() {
        return (List<Movimiento>) movimientoRepository.findAll();
    }

    @Override
    @Transactional
    public MovimientoDTO save(MovimientoDTO movimientoDTO) {
        try {
            Movimiento movimiento = new Movimiento();

            movimiento.setConcepto(movimientoDTO.getConcepto());

            Optional<Inversion> inversionOptional = inversionRepository.findById(movimientoDTO.getInversion());
            Optional<Categoria> categoriaOptional = categoriaRepository.findById(movimientoDTO.getCategoria());
            Optional<Moneda> monedaOptional = monedaRepository.findById(movimientoDTO.getMoneda());
            Optional<Medida> medidaOptional = medidaRepository.findById(movimientoDTO.getMedida());

            if (inversionOptional.isPresent()) {
                movimiento.setInversion(inversionOptional.orElseThrow());
            }

            if (categoriaOptional.isPresent()) {
                movimiento.setCategoria(categoriaOptional.orElseThrow());
            }

            if (movimientoDTO.getMoneda() != null) {
                if (monedaOptional.isPresent()) {
                    movimiento.setMoneda(monedaOptional.orElseThrow());
                }
            }

            if (movimientoDTO.getMedida() != null) {
                if (medidaOptional.isPresent()) {
                    movimiento.setMedida(medidaOptional.orElseThrow());
                }
            }

            if (movimientoDTO.getActividades() == null || movimientoDTO.getActividades().isEmpty()) {
                throw new IllegalStateException("El movimiento debe tener al menos una actividad asociada");
            }

            for (ActividadDTO actividadDTO : movimientoDTO.getActividades()) {
                ActividadSocio actividadSocio = new ActividadSocio();
                actividadSocio.setMonto(actividadDTO.getMonto());
                actividadSocio.setCantidad(actividadDTO.getCantidad());
                actividadSocio.setFecha(actividadDTO.getFecha());

                Optional<Socio> socioOptional = socioRepository.findById(actividadDTO.getSocio());
                Optional<TipoActividad> tipoActividadOptional = tipoActividadRepository
                        .findById(actividadDTO.getTipoActividad());

                if (socioOptional.isPresent()) {
                    actividadSocio.setSocio(socioOptional.orElseThrow());
                }

                if (tipoActividadOptional.isPresent()) {
                    actividadSocio.setTipoActividad(tipoActividadOptional.orElseThrow());
                }

                movimiento.addActividadSocio(actividadSocio);
            }

            movimientoRepository.save(movimiento);
            return movimientoDTO;
        } catch (Exception e) {
            e.printStackTrace();
            throw new UnsupportedOperationException("Error al registrar el movimiento");
        }
    }

}
