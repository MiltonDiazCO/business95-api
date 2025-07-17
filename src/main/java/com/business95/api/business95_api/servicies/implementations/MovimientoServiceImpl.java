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
import com.business95.api.business95_api.exceptions.ActividadRequeridaException;
import com.business95.api.business95_api.exceptions.CategoriaNoEncontradaException;
import com.business95.api.business95_api.exceptions.MedidaNoEncontradaException;
import com.business95.api.business95_api.exceptions.MonedaNoEncontradaException;
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

        Movimiento movimiento = new Movimiento();

        movimiento.setConcepto(movimientoDTO.getConcepto());

        movimiento.setInversion(inversionRepository.findById(movimientoDTO.getInversion()).orElseThrow());

        movimiento.setCategoria(categoriaRepository.findById(movimientoDTO.getCategoria())
                .orElseThrow(() -> new CategoriaNoEncontradaException(movimientoDTO.getInversion())));

        movimiento.setMoneda(monedaRepository.findById(movimientoDTO.getMoneda())
                .orElseThrow(() -> new MonedaNoEncontradaException(movimientoDTO.getMoneda())));

        movimiento.setMedida(medidaRepository.findById(movimientoDTO.getMedida())
                .orElseThrow(() -> new MedidaNoEncontradaException(movimientoDTO.getMedida())));

        if (movimientoDTO.getActividades() == null || movimientoDTO.getActividades().isEmpty()) {
            throw new ActividadRequeridaException();
        }

        for (ActividadDTO actividadDTO : movimientoDTO.getActividades()) {
            ActividadSocio actividadSocio = new ActividadSocio();
            actividadSocio.setMonto(actividadDTO.getMonto());
            actividadSocio.setCantidad(actividadDTO.getCantidad());
            actividadSocio.setFecha(actividadDTO.getFecha());

            actividadSocio.setSocio(socioRepository.findById(actividadDTO.getSocio()).orElseThrow());

            actividadSocio.setTipoActividad(
                    tipoActividadRepository.findById(actividadDTO.getTipoActividad()).orElseThrow());

            movimiento.addActividadSocio(actividadSocio);
        }

        movimientoRepository.save(movimiento);
        return movimientoDTO;

    }

}
