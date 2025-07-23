package com.business95.api.business95_api.servicies.implementations;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.business95.api.business95_api.dto.ActividadRegistroDTO;
import com.business95.api.business95_api.dto.MovimientoConsultaDTO;
import com.business95.api.business95_api.dto.MovimientoRegistroDTO;
import com.business95.api.business95_api.entities.ActividadSocio;
import com.business95.api.business95_api.entities.Movimiento;
import com.business95.api.business95_api.exceptions.CategoriaNoEncontradaException;
import com.business95.api.business95_api.exceptions.InversionNoEncontradaException;
import com.business95.api.business95_api.exceptions.MedidaNoEncontradaException;
import com.business95.api.business95_api.exceptions.MonedaNoEncontradaException;
import com.business95.api.business95_api.exceptions.SocioNoEncontradoException;
import com.business95.api.business95_api.exceptions.TipoActividadNoEncontradoException;
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
        @Transactional(readOnly = true)
        public List<MovimientoConsultaDTO> findMovimientoDTOById(Long idMovimiento) {
                return movimientoRepository.findMovimientoDTOById(idMovimiento);
        }

        @Override
        @Transactional
        public MovimientoRegistroDTO save(MovimientoRegistroDTO movimientoRegistroDTO) {

                Movimiento movimiento = new Movimiento();

                movimiento.setConcepto(movimientoRegistroDTO.getConcepto());

                movimiento.setInversion(inversionRepository.findById(movimientoRegistroDTO.getInversion())
                                .orElseThrow(() -> new InversionNoEncontradaException(
                                                movimientoRegistroDTO.getInversion())));

                movimiento.setCategoria(categoriaRepository.findById(movimientoRegistroDTO.getCategoria())
                                .orElseThrow(() -> new CategoriaNoEncontradaException(
                                                movimientoRegistroDTO.getCategoria())));

                movimiento.setMoneda(monedaRepository.findById(movimientoRegistroDTO.getMoneda())
                                .orElseThrow(() -> new MonedaNoEncontradaException(movimientoRegistroDTO.getMoneda())));

                movimiento.setMedida(medidaRepository.findById(movimientoRegistroDTO.getMedida())
                                .orElseThrow(() -> new MedidaNoEncontradaException(movimientoRegistroDTO.getMedida())));

                for (ActividadRegistroDTO actividadRegistroDTO : movimientoRegistroDTO.getActividades()) {
                        ActividadSocio actividadSocio = new ActividadSocio();
                        actividadSocio.setMonto(actividadRegistroDTO.getMonto());
                        actividadSocio.setCantidad(actividadRegistroDTO.getCantidad());
                        actividadSocio.setFecha(actividadRegistroDTO.getFecha());

                        actividadSocio.setSocio(socioRepository.findById(actividadRegistroDTO.getSocio())
                                        .orElseThrow(() -> new SocioNoEncontradoException(
                                                        actividadRegistroDTO.getSocio())));

                        actividadSocio.setTipoActividad(
                                        tipoActividadRepository.findById(actividadRegistroDTO.getTipoActividad())
                                                        .orElseThrow(
                                                                        () -> new TipoActividadNoEncontradoException(
                                                                                        actividadRegistroDTO
                                                                                                        .getTipoActividad())));

                        movimiento.addActividadSocio(actividadSocio);
                }

                movimientoRepository.save(movimiento);
                return movimientoRegistroDTO;
        }

}
